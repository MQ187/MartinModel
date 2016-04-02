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
class Gate{
    synchronized void lower() {
        System.out.println("lower gate");
        notifyAll();
    }
    
    synchronized void pass(int id) { 
        System.out.println("e."+1+".pass.gate");
        notifyAll();
    }
    
    synchronized void raise() { 
        System.out.println("raise gate");
        notifyAll();
    }
}