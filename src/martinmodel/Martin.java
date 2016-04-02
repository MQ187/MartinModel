package martinmodel;

class Martin  implements Runnable { 
    
    EnterSensor marSensor;
    ExitSensor houseSensor;
    ExitSensor exitRoad;
    Controller controller;
    
    Martin(Controller c, EnterSensor enter, ExitSensor house, ExitSensor exit) {
        controller = c;
        marSensor = enter;
        houseSensor = house;
        exitRoad = exit;
    }
  
    @Override
    public void run() {
        try {
            while(true) {
                controller.gateLower();
                controller.warningOff();
                houseSensor.exit(2);
                Thread.sleep(500);
                marSensor.enter(2);
                Thread.sleep(1000);
                exitRoad.exit(1);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e){
        }
    } 
}