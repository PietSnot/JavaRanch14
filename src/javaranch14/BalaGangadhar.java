/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaranch14;

import java.util.function.Function;

/**
 *
 * @author Piet
 */
public class BalaGangadhar {
    
    public static void main(String... args) {
        System.out.println(calculate(5, (Integer i) -> 2 * i));
        
        // java 7 way?
        BalaFunction<Integer, Integer> f = new BalaFunction<Integer, Integer>() {
            @Override
            public Integer apply(Integer i) {
                return 2 * i;
            }
        };
        
        System.out.println(calculate(5, f));
    }
    
    public static <T, S> S calculate(T input, BalaFunction<T, S> f) {
        return f.apply(input);
    }
}

interface BalaFunction<T, S> {
    S apply(T t);
}
