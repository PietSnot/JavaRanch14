/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaranch14;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

/**
 *
 * @author Piet
 */
public class KevinFarmer {
    public static void main(String... args) {
         String[][] graphIn = { { "c1", "c3" }, { "c2", "c3" }, { "c3", "c4", "c5" }, { "c4", "c5" }, { "c5" } };
         Map<String, Set<String>> map = new TreeMap<>();
         Arrays.stream(graphIn)
             .map(KevinFarmer::convertToSet)
             .forEach(c -> map.put(c.first(), c.tailSet(c.first(), false)));
         ;
         System.out.println(map);
         System.out.println("Vertices: " + map.keySet());
    }
    
    private static TreeSet<String> convertToSet(String[] a) {
        return Arrays.stream(a).collect(Collectors.toCollection(TreeSet::new));
    }
}
