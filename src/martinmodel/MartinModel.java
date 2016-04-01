package martinmodel;

/**
 *
 * @author moq
 */
public class MartinModel{

    int maxEnemies = 3;

    Thread enemies[];
    Thread martin;
    
    Gate gate;

    public void start() {
        Controller c = new Controller(maxEnemies, gate);
        enemies = new Thread[maxEnemies];
        martin = new Thread(new Martin(c));
        gate = new Gate();
        
        for (int i = 1; i<maxEnemies; i++) {
            enemies[i] = new Thread(new Enemy(c,i));
        }
        
        for (int i = 0; i<maxEnemies; i++) {
            enemies[i].start();
            martin.start();
        }
    }

    public void stop() {
        for (int i = 0; i<maxEnemies; i++) {
            enemies[i].interrupt();
        }
        martin.interrupt();
    }
 }
