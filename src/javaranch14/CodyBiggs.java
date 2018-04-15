/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaranch14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

/**
 *
 * @author Piet
 */
public class CodyBiggs {

}

class Bank {

    public static void main(String[] args) {
        // shortest time to service a customer; must be greater than zero
        int MINIMUM_DURATION = 1;

        // longest time to service a customer; must be greater than the minimum duration
        int MAXIMUM_DURATION = 5;

        // average customers arriving per given minute.  This would mean three customers every four minutes.
        double CUST_PER_MINUTE = .75;

        // how long the simulation represents; 120 would equal two hours
        int SIMULATION_DURATION = 8;

        // The number of tellers for this run of the simulation
        int NUM_TELLERS = 1;

        // Create the customer generator
        CustomerGenerator frontdoor = new CustomerGenerator(MINIMUM_DURATION, MAXIMUM_DURATION, CUST_PER_MINUTE, SIMULATION_DURATION, 0);
        List<Teller> tellerList = new ArrayList<>();
        Queue<Customer> customerQueue = new LinkedList<>();

        for (int i = 0; i < NUM_TELLERS; i++) {

            tellerList.add(new Teller(customerQueue));
        }

        for (int timeSlot = 0; timeSlot < SIMULATION_DURATION || customerQueue.size() > 0; timeSlot++) {
            // get the queue of arriving customers from the frontdoor
            Queue<Customer> arrivals = frontdoor.GetCustomers(timeSlot);

            for (int i = 0; i < arrivals.size(); i++) {
                // draw out on paper

                Customer c = arrivals.remove();

                customerQueue.add(c);
            }

            for (Teller teller : tellerList) {
                teller.ProcessNextCustomer(timeSlot);
            }

        }
        // TODO -- print the statistics
        // You'll need to walk through your list of Tellers figuring out longest wait time, total wait time, etc.

    }
}

class Teller {
    // our quueue of customers
    private Queue<Customer> custQ;
    // the tick of the clock when the teller becomes free
    private int nextFree = 0;

    // the amount of time the teller is idle
    public int IdleTime = 0;
    public int getIdleTime() {
        return IdleTime;
    }
    public void setIdleTime(int n) {
        IdleTime = n;
    }

    // the number of customers served
    public int CustomersServed = 0;
    public int getCustomersServed() {
        return CustomersServed;
    }
    public void setCustomersServed(int n) {
        CustomersServed = n;
    }

    // the longest time that one of this teller's customers has waited
    public int MaxWaitTime = 0;
    public int getMaxWaitTime() {
        return MaxWaitTime;
    }
    public void setMaxWaitTime( int n) {
        MaxWaitTime = n;
    }

    // the total amount of time that all of this teller's customers have waited
    public int TotalWaitTime = 0;
    public int getTotalWaitTime() {
        return TotalWaitTime;
    }
    public void setTotalWaitTime(int n) {
        TotalWaitTime = n;
    }

    // Constructor accepts the queue of customers from which to pull the next customer
    // There are other ways to do this, but this makes part B less painful
    public Teller(Queue<Customer> q) {
        custQ = q;
    }

    /// <summary>
    /// Begins helping a customer if the teller is not busy AND a customer is waiting
    /// </summary>
    /// <param name="now">The time on the bank's clock, in minutes from the start, i.e. timeslot.</param>
    public void ProcessNextCustomer(int now) {
        // busy?
        if (now >= nextFree) {
            if (custQ.size() > 0) {
                Customer customer = custQ.remove();
                nextFree = now + customer.TransactionDuration;
                int waitTime = now - customer.ArrivalTime;
                TotalWaitTime += waitTime;

                if (MaxWaitTime < waitTime) {
                    MaxWaitTime = waitTime;
                }

            }
            else {
                IdleTime++;
            }
        }
    }
}

class CustomerGenerator {
    private int[] customerArrivals;
    private int minDuration;
    private int maxDuration;
    private Random rand;

    /// <summary>
    /// Creates the generator and initializes the random number generator for populating the customer queues.
    /// </summary>
    /// <param name="minDuration">The minimum amount of time that it will take to process a customer's request.</param>
    /// <param name="maxDuration">The maximum amount of time that it will take to process a customer's request.</param>
    /// <param name="avgPerSlot">The average number of customers that will arrive per time slot.</param>
    /// <param name="totalTime">Total number of time slots for which customers are to be generated.</param>
    /// <param name="seed">If present, the this value is passed as the seed to the random number generator.  If the seed is negative, no seed is passed.</param>
    public CustomerGenerator(int minDuration, int maxDuration, double avgPerSlot, int totalTime, int seed) {
        if (seed < 0) rand = new Random();
        else rand = new Random(seed);

        customerArrivals = new int[totalTime];
        this.minDuration = minDuration;
        this.maxDuration = maxDuration;
        initializeArrivals(avgPerSlot, totalTime);
    }

    /// <summary>
    /// Initializes an array containing the number of customers that will be generated for each time slot.
    /// </summary>
    /// <param name="avgPerSlot">The average number of customers that will arrive per time slot.</param>
    /// <param name="slots">Total number of time slots for which customers are to be generated.</param>
    private void initializeArrivals(double avgPerSlot, int slots) {
        for (int i = 0; i < slots * avgPerSlot; i++) {
            int slot = rand.nextInt(slots);
            customerArrivals[slot]++;
        }
        System.out.println(Arrays.toString(customerArrivals));
    }

    /// <summary>
    /// Returns a Queue of customers that are generated for the given time slot.
    /// </summary>
    /// <param name="timeSlot">The time slot for which the customers are to be generated.</param>
    /// <returns>The Queue of customers.  This queue may be empty.</returns>
    public Queue<Customer> GetCustomers(int timeSlot) {
        Queue<Customer> customers = new LinkedList<Customer>();

        // Make cettain we haven't gone beyond the time; this could happen whlle
        // the queue of waiting customers is emptied
        if (timeSlot < customerArrivals.length) {
            // Our pre-generated array contains the number of customers for any given timeslot
            int numArrivals = customerArrivals[timeSlot];

            while (numArrivals > 0) {
                int duration = rand.nextInt(maxDuration - minDuration + 1) + minDuration;
                Customer customer = new Customer(timeSlot, duration);
                customers.add(customer);
                numArrivals--;
            }
        }
        return customers;
    }
}

class Customer {
    // The time (i.e. minutes from the start of the simulation) that the customer arrives
    public final int ArrivalTime;

    // The number of minutes that it will take to service this customer
    public final int TransactionDuration;

    // The time (minutes from the start) that the customer actually gets to see a Teller; depending on your
    // implementation, this may not be needed.
    public int ServiceTime = 0;
    public int getServiceTime() {
        return ServiceTime;
    }
    public void setServiceTime(int n) {
        ServiceTime = n;
    }

    // The constructor is called from the generator; you never need to create a customer
    public Customer(int arrival, int duration)
    {
        ArrivalTime = arrival;
        TransactionDuration = duration;
    }

    // For debugging purposes
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("Customer [arrivalTime=");
        builder.append(ArrivalTime);
        builder.append(", transactionDuration=");
        builder.append(TransactionDuration);
        builder.append(", serviceTime=");
        builder.append(ServiceTime);
        builder.append("]");
        return builder.toString();
    }
}