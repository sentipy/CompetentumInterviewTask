package com.sentilabs.interviews.competentum.customers;

import com.sentilabs.interviews.competentum.customers.types.CustomerType;

import java.util.*;

/**
 * Created by sentipy on 22/03/15.
 */
public class CustomerGenerator {

    private int manProcent;
    private int womanProcent;
    private int childProc;
    private List<CustomerType> customerTypeList = new ArrayList<>();

    public CustomerGenerator(int manProcent, int womanProcent, int childProc) {
        this.manProcent = manProcent;
        this.womanProcent = womanProcent;
        this.childProc = childProc;
    }

    private void addCustomersToList(int amount, CustomerType customerType){
        for (int i = 0; i < amount; ++i){
            customerTypeList.add(customerType);
        }
    }

    public ICustomer generateCustomer(int maxAmountInHands){
        if (customerTypeList.size() == 0){
            this.addCustomersToList(this.manProcent, CustomerType.MAN);
            this.addCustomersToList(this.womanProcent, CustomerType.WOMAN);
            this.addCustomersToList(this.childProc, CustomerType.CHILD);
            Collections.shuffle(customerTypeList);
        }
        return new Customer(new Random().nextInt(maxAmountInHands + 1), customerTypeList.remove(0));
    }
}
