package martinmodel;

/**
 *
 * @author moq
 */
class Controller {
    private int MAX = 0;
    private int eCount = 0;
    private boolean canEnter = false;
    private Indicator warning;
    private Gate gate;
    private ExitSensor roadSensor;

    Controller(int m, Gate g, ExitSensor road, Indicator w){
        MAX = m;
        gate = g;
        roadSensor = road;
        warning = w;
    }
  
    synchronized void enemyPass(int id) throws InterruptedException{
        while(eCount >= MAX || canEnter) wait();
        
        gate.pass(id);
        ++eCount;
        
        if(eCount==1){warning.on();}
        notifyAll();
    }
    
    synchronized void roadExit(int type) throws InterruptedException {
        roadSensor.exit(1);
        
        if(type == 1){--eCount;if(eCount == 0)gateLower();}
        if(type == 0){gateRaise();}
        
        notifyAll();
    }
    
    synchronized void gateRaise() throws InterruptedException{
        while(canEnter) wait();
        
        canEnter = false;
        gate.raise();
        notifyAll();
    }
    
    synchronized void gateLower() throws InterruptedException{
        canEnter = true;
        gate.lower();
        warningOff();
    }
    
    synchronized void warningOff() throws InterruptedException{
        while((eCount>0)&&(!canEnter)) wait();
        
        warning.off();
        notifyAll();
    }
}
