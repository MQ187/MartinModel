package martinmodel;

/**
 *
 * @author moq
 */
class Martin  implements Runnable { 
    
    EnterSensor marSensor;
    ExitSensor houseSensor;
    ExitSensor exitRoad;
    Controller controller;
    
    Martin(Controller c, EnterSensor enter, ExitSensor house) {
        controller = c;
        marSensor = enter;
        houseSensor = house;
    }
  
    @Override
    public void run() {
        try {
            while(true) {
                controller.warningOff();
                houseSensor.exit(2);
                Thread.sleep(500);
                marSensor.enter(2);
                Thread.sleep(1000);
                controller.roadExit(0);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e){
        }
    } 
}