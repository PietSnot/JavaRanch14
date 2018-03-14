/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaranch14;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.util.Scanner;

/**
 *
 * @author Piet
 */
public class SeanMcintosh {
    
}

class Main {
 
    private static Scanner scanner = new Scanner(System.in);
 
    public static void main(String[] args) {
        int[] myIntegers = getIntegers();
        for (int i = 0; i < myIntegers.length; i++) {
        }
        System.out.println("My first array is: " + commas(myIntegers));
        System.out.println("The average of your whole numbers is " + getAverage(myIntegers));
        System.out.println("The largest of your three numbers is " + max(myIntegers));
String year = "2020 11 05";
DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy M d");
LocalDate date = LocalDate.parse(year, dateTimeFormatter);
System.out.println(date);

String flup = "2020";
DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy");
TemporalAccessor ta = dtf.parse(flup);
System.out.println("year is: " + ta.get(ChronoField.YEAR));

 
    }
 
    public static int[] getIntegers() {
 
        System.out.println("Enter three whole numbers.");
        int[] values = new int[3];
 
//        for (int i = 0; i < values.length; i++) {
//            values[i] = scanner.nextInt();
//        }
//        return values;
        return new int[] {1, 3, 4};
    }
 
    public static double getAverage(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
 
        return (double) sum / (double) array.length;
    }
 
    public static int max(int[] array) {
        int largestValue = array[0];
        for (int i = 0; i < array.length; i++) {
            if (i > largestValue) {
                largestValue = array[i];
            }
        }
        return largestValue;
    }
 
    public static int commas(int[] array) {
        int clean = array[0];
        for (int i = 0; i < array.length; i++) {
            if (i!=0) {
                System.out.print(", ");
            }
            System.out.print(array[i]);
        }
        System.out.println();
        return clean;
    }
 
 
}

