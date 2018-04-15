/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaranch14;

import java.util.stream.Stream;

/**
 *
 * @author Piet
 */
public class ArpanGhoshal2 {

}

class Runner {

    private int numberMinutes;

    public Runner(int n) {
        numberMinutes = n;
    }

    public int getNumberMinutes() {
        return numberMinutes;
    }

    public boolean isFourMinuteMile() {
        return numberMinutes < 4 * 60;
    }
}

class Marathon {

    public static void main(String[] args) {
Stream<Runner> runners = Stream.of(new Runner(250), new Runner(600), new Runner(201));
runners.map(Runner::isFourMinuteMile).forEach(System.out::println); 
Stream<Runner> runners2 = Stream.of(new Runner(250), new Runner(600), new Runner(201));
runners2.filter(Runner::isFourMinuteMile).forEach(System.out::println);
    }
}
