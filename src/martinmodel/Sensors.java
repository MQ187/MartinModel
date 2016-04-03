package martinmodel;

/**
 *
 * @author moq
 */
class EnterSensor {
    synchronized void enter(int type) { 
        switch (type){
            case 1: System.out.println("enemy.enter.sensor"); break;
            case 2: System.out.println("martin.enter.sensor"); break;
        }
        notifyAll();
    }
}

class ExitSensor {
    synchronized void exit(int type) { 
        switch (type){
            case 1: System.out.println("road.exit.sensor"); break;
            case 2: System.out.println("house.exit.sensor"); break;
        }
        notifyAll();
    }
}
