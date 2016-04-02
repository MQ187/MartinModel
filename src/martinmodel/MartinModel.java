package martinmodel;

import static java.lang.Thread.sleep;

/**
 *
 * @author moq
 */
public class MartinModel{

    final static int MAX_ENEMIES = 3;

    Thread enemies[];
    Thread martin;
    
    Controller c;
    Gate gate;
    EnterSensor enSensor, marSensor;
    ExitSensor road, house;
    Indicator i;
    
    public void start() {
        enSensor = new EnterSensor();
        marSensor = new EnterSensor();
        road = new ExitSensor();
        house = new ExitSensor();
        i = new Indicator();
        
        gate = new Gate();
        c = new Controller(MAX_ENEMIES, gate, road, i);
        
        enemies = new Thread[MAX_ENEMIES];
        martin = new Thread(new Martin(c, marSensor, house, road));
        for (int i = 0; i < MAX_ENEMIES; i++) {
            enemies[i] = new Thread(new Enemy(c,i+1,enSensor));
        }
        
        for (int i = 0; i<MAX_ENEMIES; i++) {
            martin.run();
            enemies[i].run();
        }
      
    }

    public void stop() {
        for (int i = 0; i<MAX_ENEMIES; i++) {
            enemies[i].interrupt();
        }
        martin.interrupt();
    }
    
      public static void main(String[] args) throws InterruptedException {
      
          MartinModel mModel = new MartinModel();
          mModel.start();
          
      
      }
 }