/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaranch14;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Piet
 */
public class ArpanGhoshal {

}

class test {

    <T> void meth(T a) {
        System.out.println("T " + a);
    }

    void meth(Collection<?> a) {
        System.out.println("Collection: " + a);
    }
    
}

class MyClass {

    public static void main(String args[]) {

        test ref = new test();

        List<String> ob = new ArrayList<>();

        ob.add("String 1");
        ob.add("String 2");
        ob.add("String 3");

        ref.meth(ob);
    }
}
