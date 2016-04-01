package martinmodel;

class Martin implements Runnable { 
    
    EnterSensor marSensor;
    ExitSensor houseSensor;
    ExitSensor exitRoad;
    Controller controller;
    
    Martin(Controller c) {
        controller = c;
    }
  
    public void run() {
        try {
            while(true) {
                houseSensor.exit();
                marSensor.enter();
                Thread.sleep(1000);
                exitRoad.exit();
            }
        } catch (InterruptedException e){
        }
    } 
}