package com.sentilabs.interviews.competentum.customers;

import com.sentilabs.interviews.competentum.customers.types.CustomerType;

/**
 * Created by sentipy on 22/03/15.
 */
public class Customer implements ICustomer {

    private int amountInHands;
    private final int initialAmountInHands;
    private final CustomerType customerType;

    public Customer(int amountInHands, CustomerType customerType){
        this.initialAmountInHands = amountInHands;
        this.amountInHands = amountInHands;
        this.customerType = customerType;
    }

    @Override
    public int getInitialAmountInHands() {
        return initialAmountInHands;
    }

    @Override
    public int getAmountInHands() {
        return this.amountInHands;
    }

    @Override
    public void reduceAmountInHands(int amount) {
        this.amountInHands -= amount;
        if (this.amountInHands < 0){
            this.amountInHands = 0;
        }
    }

    public CustomerType getCustomerType() {
        return customerType;
    }
}
