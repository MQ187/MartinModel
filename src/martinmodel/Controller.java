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

    Controller(int n, Gate g){
        eCount = n;
        gate = g;
    }
  
    synchronized void enemyPass(){
        gate.pass();
        ++eCount;
    }
    
    synchronized void roadExit() {
        --eCount;
    }
    
    synchronized void gateRaise() throws InterruptedException{
        gate.lower();
    }
    
    synchronized void warningOff() throws InterruptedException{
        while((eCount>0)&&(!canEnter)) wait();
        
        if(warning.off()){
            gate.lower();
        }
    }
}
