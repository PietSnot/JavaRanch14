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
public class StephenBell {
    public static void main(String... args) {
        List<? super Residential> lowerBList = new ArrayList<Residential>();
//List<? extends Building> lowerBList = new ArrayList<Residential>();
//List<Residential> upperBList = lowerBList; //Doesn't compile!

List<? extends Building> upperList= new ArrayList<Building>(); 
//upperList.add(new Building());
        
    }
}

class Building {}
class Residential extends Building {}

