/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaranch14;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 *
 * @author Piet
 */
public class PrasadSaya {
    public static void main(String... args) {
        String[] piet = { "a", "b", "c"};
        Stream<String> s1 = Stream.of(piet);
        Stream<String> s2 = Arrays.stream(piet);
        System.out.print("s1: "); 
        s1.forEach(System.out::println);
        System.out.println("s2: ");
        s2.forEach(System.out::println);
    }
}
