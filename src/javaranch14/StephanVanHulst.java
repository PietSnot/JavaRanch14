/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaranch14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

/**
 *
 * @author Piet
 */
public class StephanVanHulst {

}

class Combination {

    private static <T> void forEachCombination(List<? extends Iterable<? extends T>> input, Consumer<? super List<T>> action) {
        if (input.isEmpty()) {
            action.accept(new ArrayList<>());
            return;
        }

        Iterable<? extends T> prefixes = input.get(0);
        List<? extends Iterable<? extends T>> remainingInput = input.subList(1, input.size());

        prefixes.forEach(prefix
            -> forEachCombination(remainingInput, smallerCombination -> {
                List<T> combination = smallerCombination;
                combination.add(0, prefix);
                action.accept(combination);
            })
        );
    }

    public static void main(String... args) {
        List<List<String>> input = Arrays.asList(
            Arrays.asList("black", "blue", "yellow", "green", "purple", "grey", "orange", "white", "red"),
            Arrays.asList("apple", "orange", "grapes", "blueberry", "mango", "banana"),
            Arrays.asList("dog", "lion", "snake", "bear", "cow", "leopard", "monkey", "donkey"),
            Arrays.asList("black", "blue", "yellow", "green", "purple", "grey", "orange", "white", "red")
        );

        AtomicInteger counter = new AtomicInteger();

        forEachCombination(input, combination -> counter.incrementAndGet());

        System.out.println(counter);
    }
}
