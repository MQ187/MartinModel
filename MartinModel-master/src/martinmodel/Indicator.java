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
    
    Indicator(int t){
        track = t;
    }
    
    synchronized boolean on(){
        if(track >= 1){
            return true;
        }else{
            return false;
        }
    }
    
    synchronized boolean off() throws InterruptedException{
        while(track > 0) wait();
        
        return true;
    }
    
}
