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
    private final String key;
    private final String group, gene;
    private final List<Double> observations = new ArrayList<>();
    
    Statistics(String group, String gene) {
        this.group = group;
        this.gene = gene;
        key = group + "_" + gene;
    }
    
    public void addObservation(double obs) {
        observations.add(obs);
    }
    
    public double getAverage() {
        if (observations.isEmpty()) throw new RuntimeException("No observations");
        return observations.stream().mapToDouble(d -> d).sum() / observations.size();
    }
    
    public List<Double> getObservations() {
        return new ArrayList<>(observations);
    }

    public double getVariance() {
        if (observations.size() < 2) throw new RuntimeException("Less than 2 observations");
        double mean = getAverage();
        double ex2 = observations.stream().mapToDouble(d -> d * d).sum() / observations.size();
        return ex2 - mean * mean;
    }  
    
    public double getStDev() {
        return Math.sqrt(getVariance());
    }
    
    public String getGroup() {
        return group;
    }
    
    public String getGene() {
        return gene;
    }
}
