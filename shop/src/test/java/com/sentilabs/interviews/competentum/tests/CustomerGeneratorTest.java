package com.sentilabs.interviews.competentum.tests;

import com.sentilabs.interviews.competentum.customers.CustomerGenerator;
import com.sentilabs.interviews.competentum.customers.ICustomer;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerGeneratorTest {

    @Test
    public void testGenerateCustomer() throws Exception {
        final CustomerGenerator customerGenerator = new CustomerGenerator(40, 50, 10);
        final int MAX_AMOUNT = 10;
        for (int i = 0; i < 1000; ++i){
            final ICustomer customer = customerGenerator.generateCustomer(MAX_AMOUNT);
            Assert.assertTrue(customer.getInitialAmountInHands() <= MAX_AMOUNT
                    && customer.getInitialAmountInHands() >= 0);
        }
        final ICustomer customer = customerGenerator.generateCustomer(0);
        Assert.assertTrue(customer.getInitialAmountInHands() == 0);
    }
}