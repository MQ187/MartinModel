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
    
    Gate gate;

    public void start() {
        
        enemies = new Thread[MAX_ENEMIES];
        gate = new Gate();
        Controller c = new Controller(MAX_ENEMIES, gate);
         martin = new Thread(new Martin(c));
        for (int i = 0; i < MAX_ENEMIES; i++) {
            enemies[i] = new Thread(new Enemy(c,i+1));
        }
        
        for (int i = 0; i<MAX_ENEMIES; i++) {
            enemies[i].run();
            martin.run();
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


