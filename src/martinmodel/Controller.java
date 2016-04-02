package martinmodel;

/**
 *
 * @author moq
 */
class Controller {
    private int eCount = 0;
    private boolean canEnter = false;
    private Indicator warning;
    private Gate gate;
    private ExitSensor roadSensor;

    Controller(int n, Gate g, ExitSensor road, Indicator w){
        eCount = n;
        gate = g;
        roadSensor = road;
        warning = w;
    }
  
    synchronized void enemyPass(int id){
        gate.pass(id);
        ++eCount;
    }
    
    synchronized void roadExit() {
        roadSensor.exit(1);
        --eCount;
    }
    
    synchronized void gateRaise() throws InterruptedException{
        gate.raise();
    }
    
    synchronized void gateLower() throws InterruptedException{
        canEnter = true;
    }
    
    synchronized void warningOff() throws InterruptedException{
        while((eCount>0)&&(!canEnter)) wait();
        
        warning.off();
        gate.lower();
    }
}
