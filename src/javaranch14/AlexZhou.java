/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaranch14;

import java.awt.Point;
import java.util.function.Predicate;

/**
 *
 * @author Piet
 */
public class AlexZhou {
    
}

class MyClass2 {
    public static void main(String args[]) {
        Predicate<? extends Object> p = s -> s.hashCode() < 1_000;
//        helper(new Point(), p);
//        helper(new Object(), p);
//        helper("x", p);
        
    }
     
    static <T> void helper(T t, Predicate<? super T> p){
        System.out.println(p.test(t));
    } 
    
    static <T> Predicate<T> createPredicate() {
        return s -> s.hashCode() < 1_000;
    }
}

