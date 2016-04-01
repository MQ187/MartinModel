package martinmodel;

class Enemy implements Runnable { 
    
    Gate gate;
    EnterSensor enSensor;
    ExitSensor exitRoad;
    Controller controller;
    int id;
    
    Enemy(Controller c, int id) {
        controller = c;
        this.id = id;
    }
  
    public void run() {
        try {
            while(true) {
                gate.pass();
                enSensor.enter();
                Thread.sleep(1000);
                exitRoad.exit();
            }
        } catch (InterruptedException e){
        
        }
    } 
}