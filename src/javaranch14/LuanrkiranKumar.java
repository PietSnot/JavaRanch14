/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaranch14;

/**
 *
 * @author Piet
 */
public class LuanrkiranKumar {

}

class A {

    A() {
        System.out.println("class A");
    }
}

class B extends A {

    B() {
        System.out.println("class B");
    }

    public static void main(String args[]) {
        B b = new B();
    }
}
