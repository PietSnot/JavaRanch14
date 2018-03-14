/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaranch14;

import java.util.Random;
import java.util.stream.IntStream;

/**
 *
 * @author Piet
 */
public class CharlieSwift {
    
    //------------------------------------------------------------------
    public static void main(String... args) {
        new CharlieSwift().go();
    }
    
    //------------------------------------------------------------------
    private void go() {
        int nrToRoll = 1;
        int timesToRoll = 4;
        int nrOfFacesOfDie = 6;
        Die die = new Die(nrOfFacesOfDie);
        System.out.format("nr of rolls to get %d consequetive %d's: %,d%n", 
            timesToRoll, nrToRoll, numbersRolled(die, nrToRoll, timesToRoll))
        ;
    }
    
    //------------------------------------------------------------------
    public int numbersRolled(Die die, int numberToRoll, int timesToRoll) {
        int[] a = new int[1];
        return IntStream.iterate(1, i -> i + 1)
            .filter(i -> {a[0] = die.roll() == numberToRoll ? a[0] + 1 : 0; return a[0] == timesToRoll;})
            .findFirst()
            .getAsInt()
        ;
    }
    
    //------------------------------------------------------------------
    private static class Die {
        final int nrOfFaces;
        final Random r = new Random();
        public Die(int faces) {
            nrOfFaces = faces;
        }
        public int roll() {
            return r.nextInt(nrOfFaces) + 1;
        }
    }
    //------------------------------------------------------------------
}