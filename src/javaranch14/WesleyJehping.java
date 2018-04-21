/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaranch14;

import java.util.ArrayList;

/**
 *
 * @author Piet
 */
public class WesleyJehping {

    public static void main(String... args) {
        Doctor doctor2 = new Doctor();
        String tempName1 = null;
        if (doctor2 != null) {
            if ("".equalsIgnoreCase(doctor2.getName())) {
                System.out.println("Error: Dr. " + doctor2.getName() + " has already been added. Please try a different name");
                tempName1 = "";
            }
        }
    }
}

class Doctor {
    String name;
    Doctor() {
    }
    Doctor(String s) {
        name = s;
    }
    public String getName() {
        return name;
    }
}
