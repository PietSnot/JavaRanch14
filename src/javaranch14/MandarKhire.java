/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaranch14;

import java.util.Arrays;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.joining;
import java.util.stream.IntStream;

/**
 *
 * @author Piet
 */
public class MandarKhire {
    
}

class TruthTableGenerator {
    static int size = 4;
    static int total = (int) (Math.pow(2, size) + .01);
    static String zeros = IntStream.range(1, size).mapToObj(i -> "0").collect(Collectors.joining());
    static long t1;
    static long t2;
 
    public static void main(String args[]) {
        t1 = System.nanoTime();
        System.out.println("possibilities =" + power(size, size));
        System.out.println();
        generateTable(0, size, new int[size]);
        t2 = System.nanoTime();
        System.out.println("Total Time =" + ((double) (t2 - t1) / 1000000000.0));
        
        IntStream.range(0, total).mapToObj(TruthTableGenerator::getBinaryString).forEach(System.out::println);
    }
            
    static String getBinaryString(int i) {
        String t = zeros + Integer.toBinaryString(i);
        return t.chars().skip(t.length() - size).mapToObj(c -> c == '0' ? "F" : "T").collect(joining(" "));
    }
 
    static int power(int x, int y) {
        if (y == 0) {
            return 1;
        } else if (y % 2 == 0) {
            return (power(x, y / 2) * power(x, y / 2));
        } else {
            return (x * power(x, y / 2) * power(x, y / 2));
        }
    }
 
    private static void generateTable(int index, int size, int[] current) {
        if (index == size) {
            for (int i = 0; i < size; i++) {
                if (current[i] == 0) {
                    System.out.print("F ");
                } else if (current[i] == 1) {
                    System.out.print("T ");
                }
            }
            System.out.println();
        } else {
            for (int i = 0; i < 2; i++) {
                current[index] = i;
                generateTable(index + 1, size, current);
            }
        }
    }
}
