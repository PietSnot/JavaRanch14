/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaranch14;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

/**
 *
 * @author Piet
 */
public class RaghuKalachar {
    public static void main(String... args) {
        String flup = "abcdefghihgfedcba";
        Map<Integer, Long> fm = flup.chars().boxed().collect(groupingBy(i -> i, counting()));
        int nrOfValues = (int) fm.values().stream().filter(i  -> i % 2 == 1).count();
        switch (nrOfValues) {
            case 0:
                if (flup.length() % 2 != 0) {
                    System.out.println("No palindrome");
                    break;
                }
                else {
                    System.out.println(checkForPalinDrome(flup));
                }
            case 1: 
                if (flup.length() % 2 != 1) {
                        System.out.println("No palindrome");
                }
                else {
                    System.out.println(checkForPalinDrome(flup));
                    break;
                }
            default:
                System.out.println("No palindrome");
                
        } 
    }
    
    private static List<Character> createList(String s) {
        return s.chars().mapToObj(i -> (char) i).collect(toList());
    }
    
    // check for palindrome
    private static boolean checkForPalinDrome(String flup) {
        List<Character> list = createList(flup);
        List<Character> listR = new ArrayList<>(list);
        Collections.reverse(listR);
        return list.equals(listR);
    }
}
