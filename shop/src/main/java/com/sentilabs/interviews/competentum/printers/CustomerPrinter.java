package com.sentilabs.interviews.competentum.printers;

import com.sentilabs.interviews.competentum.customers.ICustomer;

/**
 * Created by sentipy on 22/03/15.
 */
public class CustomerPrinter {

    public String print(ICustomer customer) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[" + customer.getCustomerType().toString().charAt(0) + "-");
        stringBuilder.append(customer.getAmountInHands() + "/" + customer.getInitialAmountInHands());
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
