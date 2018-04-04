/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaranch14;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Piet
 */
public class ArpanGhoshal {

}

class test {

//<T extends Collection<?>> void meth(T a) {
//    System.out.println("T " + a.size());
//}

void meth(Collection<?> a) {
    System.out.println("T " + a.size());
}

//    void meth(List<?> a) {
//        System.out.println("List: " + a);
//    }

//    void meth(Collection<String> a) {
//        System.out.println("Collection: " + a);
//    }
}

class MyClass {

    public static void main(String args[]) {

        test ref = new test();

        Collection<String> ob = new ArrayList<>();

        ob.add("String 1");
        ob.add("String 2");
        ob.add("String 3");

        ref.meth(ob);
        
        Set<Point> set = new HashSet<>(Arrays.asList(new Point(), new Point()));
        ref.meth(set);
    }
}

class Test2 {
    Integer a = 1;
}