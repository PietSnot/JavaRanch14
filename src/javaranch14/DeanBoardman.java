/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaranch14;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Piet
 */
public class DeanBoardman {
    public static void main(String... args) {
        new DeanBoardman().go();
    }
    
    public void go() {
        
    }
    
    
}

class Statistics {
    List<Double> observations = new ArrayList<>();
    
    public void addObservation(double obs) {
        observations.add(obs);
    }
    
    public double getAverage() {
        return 0; // there are some nice java 8 streams to help you with this
    }

    public double getVariance() {
        return 0;
    }  
}
