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
public class Indicator {
    
    int track = 0;
    
    Indicator(){
    }
    
    synchronized void on(){
         System.out.println("indicator.on");
         notifyAll();
    }
    
    synchronized void off() throws InterruptedException{
        System.out.println("indicator.off");
        notifyAll();
    }
    
}
