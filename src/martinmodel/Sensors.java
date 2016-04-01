/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package martinmodel;

/**
 *
 * @author moq
 */
class EnterSensor {
    synchronized void enter() { 
        notifyAll();
    }
}

class ExitSensor {
    synchronized void exit() { 
        notifyAll();
    }
}
