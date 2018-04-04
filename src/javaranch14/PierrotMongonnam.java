/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaranch14;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;

/**
 *
 * @author Piet
 */
public class PierrotMongonnam {
    public static void main(String... args) {
        BiConsumer<Averager, Integer> bic = Averager::accept;
        BiFunction<String, Integer, Character> bic2 = String::charAt;
    }
}

class Averager  {

    private int total = 0;
    private int count = 0;

    public double average() {
        return count > 0 ? ((double) total) / count : 0;
    }

    public void accept(int i) {
        total += i;
        count++;
    }

    public void combine(Averager other) {
        total += other.total;
        count += other.count;
    }
}
