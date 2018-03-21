/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaranch14;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

/**
 *
 * @author Piet
 */
public class VedanshiPriyadarshi {
    
    public static void main(String... args) {
        double[][] array = { {1, 2, 3, 4}, {}, {-1, 3, 0}};
        double[] min = Arrays.stream(array)
            .mapToDouble(VedanshiPriyadarshi::getMinimum)
//              .mapToDouble(a -> getMinimum(a))
            .toArray()
        ;
        System.out.println(Arrays.toString(min));
        Random r = new Random();
//        Predicate<String> p = Random::nextBoolean;
        BinaryOperator<Integer> q = Integer::sum;
        Predicate<String> pr = new Predicate<String>() {
            @Override
            public boolean test(String t) {
                return t.length() == 4;
            }
        };
List<String> strings = Arrays.asList("aap", "noot", "mies");
List<String> filtered = filter(strings, pr);
System.out.println(filtered);
        
        // new way
        Predicate<String> java8Predicate = (String s) -> s.length() == 4;
        List<String> filtered2 = filter(strings, pr);
        System.out.println(filtered);
        
    }
    
public static List<String> filter(List<String> list, Predicate<String> p) {
    List<String> result = new ArrayList<>();
    for (String s: list) {
        if (p.test(s)) result.add(s);
    }
    return result;    
}
    
    public static double getMinimum(double[] array) {
        return Arrays.stream(array).min().orElse(0.0);
    }
}
