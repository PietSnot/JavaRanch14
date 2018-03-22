/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaranch14;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Piet
 */
public class BinimanIdugboe {
    
}

class MethodReference
{
    public static void useRefMethod()
    {
        // build a list of persons
        List<Person2> persons = new ArrayList<>();
        persons.add(new Person2("SmiTh", "Joe", 45));
        persons.add(new Person2("mAtiAs", "Kumini", 70));
        persons.add(new Person2("ZumuLe", "Nganga", 67));
        persons.add(new Person2("Weilin", "jINchin", 50));
        persons.add(new Person2("kasiRov", "Ekatarina", 84));
         
        //print the list of persons before it is sorted
        System.out.println();
        for(Person2 p : persons)
        {
            System.out.println(p);
        }
        System.out.println();
             
        // sort the list of persons
        Comparator<Integer> comparator = Integer::compare;
        Comparator<Person2> comparator2 = (p1, p2) -> Integer.compare(p1.getWeight(), p2.getWeight());
        Comparator<Person2> comparator3 = Comparator.comparing(Person2::getWeight, Comparator.naturalOrder());
        Comparator<Person2> comparator4 = Comparator.comparing(Person2::getWeight);
         
        persons.sort(comparator4);
         
        //print the list of persons after it is sorted
        System.out.println();
        for(Person2 p : persons)
        {
            System.out.println(p);
        }
        System.out.println();
    }
     
    public static void main(String[] args)
    {
        MethodReference.useRefMethod();
    }
}
 
class Person2
    {
        String lastName;
        String firstName;
        int weight;
         
        Person2(String lastName, String firstName, int weight)
        {
            this.lastName = lastName;
            this.firstName = firstName;
            this.weight = weight;
        }
         
        public String getLastName()
        {
            return lastName;
        }
         
        public String getFirstName()
        {
            return firstName;
        }
         
        public int getWeight()
        {
            return weight;
        }
        
        @Override
        public String toString() {
            return String.format("last name: %s, first name: %s, weight: %d", lastName, firstName, weight);
        }
    }
