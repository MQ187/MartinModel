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
                gate = new Gate();
                gate.pass();
                System.out.println("enemy "+id+" passes gate");
                enSensor = new EnterSensor();
                enSensor.enter();
                controller.enemyPass();
                 System.out.println("enemy "+id+" enters road");
                Thread.sleep(1000);
                exitRoad = new ExitSensor();
                exitRoad.exit();
                controller.roadExit();
                 System.out.println("enemy "+id+" exits road");
                }
        } catch (InterruptedException e){
        
        }
    } 
}