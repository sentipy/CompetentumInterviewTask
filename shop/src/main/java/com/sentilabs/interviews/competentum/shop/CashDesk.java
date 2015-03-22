package com.sentilabs.interviews.competentum.shop;

import com.sentilabs.interviews.competentum.customers.ICustomer;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;

/**
 * Created by sentipy on 22/03/15.
 */
public class CashDesk {

    private final int throughput;
    private final Queue<ICustomer> queue = new ArrayDeque();

    public CashDesk(int throughput){
        this.throughput = throughput;
    }

    public int getThroughput() {
        return throughput;
    }

    public Queue<ICustomer> getQueue() {
        return queue;
    }

    public void step(){
        if (this.queue.size() == 0){
            return;
        }
        final ICustomer customer = this.queue.peek();
        customer.reduceAmountInHands(this.throughput);
        if (customer.getAmountInHands() <= 0){
            this.queue.remove();
        }
    }

    public Iterable<ICustomer> getCustomers(){
        return this.queue;
    }
}
