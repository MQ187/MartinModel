package martinmodel;

class Enemy implements Runnable { 
    
    EnterSensor enSensor;
    Controller controller;
    int id;
    
    Enemy(Controller c, int id, EnterSensor enter) {
        controller = c;
        this.id = id;
        enSensor = enter;
    }
  
    public void run() {
        try {
            while(true) {
                controller.enemyPass(id);
                Thread.sleep(500);
                enSensor.enter(1);
                Thread.sleep(1000);
                controller.roadExit(1);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e){
        
        }
    } 
}