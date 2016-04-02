package martinmodel;

class Martin  implements Runnable { 
    
    EnterSensor marSensor;
    ExitSensor houseSensor;
    ExitSensor exitRoad;
    Controller controller;
    
    Martin(Controller c) {
        controller = c;
    }
  
    @Override
    public void run() {
        try {
            while(true) {
                houseSensor = new ExitSensor();
                houseSensor.exit();
                System.out.println("Martin Exits house");
                marSensor = new EnterSensor();
                marSensor.enter();
                System.out.println("Martin enters road");
                Thread.sleep(1000);
                exitRoad = new ExitSensor();
                exitRoad.exit();
                System.out.println("Martin exits road");
            }
        } catch (InterruptedException e){
        }
    } 
}