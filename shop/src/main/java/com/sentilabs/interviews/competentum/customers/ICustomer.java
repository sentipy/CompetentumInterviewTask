package com.sentilabs.interviews.competentum.customers;

import com.sentilabs.interviews.competentum.customers.types.CustomerType;

/**
 * Created by sentipy on 22/03/15.
 */
public interface ICustomer {

    CustomerType getCustomerType();
    int getInitialAmountInHands();
    int getAmountInHands();
    void reduceAmountInHands(int amount);
}
