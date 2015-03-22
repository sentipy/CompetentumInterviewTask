package com.sentilabs.interviews.competentum.tests;

import com.sentilabs.interviews.competentum.customers.Customer;
import com.sentilabs.interviews.competentum.customers.types.CustomerType;
import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class CustomerTest {

    @Test
    public void testGetInitialAmountInHands() throws Exception {
        Assert.assertEquals(new Customer(100, CustomerType.CHILD).getInitialAmountInHands(), 100);
    }

    @Test
    public void testGetAmountInHands() throws Exception {
        final int AMOUNT = 100;
        final Customer customer = new Customer(AMOUNT, CustomerType.CHILD);
        customer.reduceAmountInHands(15);
        Assert.assertEquals(customer.getAmountInHands(), AMOUNT - 15);
        Assert.assertEquals(customer.getAmountInHands(), customer.getInitialAmountInHands() - 15);
    }

    @Test
    public void testReduceAmountInHands() throws Exception {
        final int AMOUNT = 100;
        final Customer customer = new Customer(AMOUNT, CustomerType.CHILD);
        final int i = new Random().nextInt(AMOUNT);
        customer.reduceAmountInHands(i);
        Assert.assertEquals(customer.getAmountInHands(), AMOUNT - i);
        Assert.assertEquals(customer.getAmountInHands(), customer.getInitialAmountInHands() - i);
    }

    @Test
    public void testGetCustomerType() throws Exception {
        Customer customer = new Customer(10, CustomerType.CHILD);
        Assert.assertEquals(customer.getCustomerType(), CustomerType.CHILD);
        customer = new Customer(10, CustomerType.MAN);
        Assert.assertEquals(customer.getCustomerType(), CustomerType.MAN);
        customer = new Customer(10, CustomerType.WOMAN);
        Assert.assertEquals(customer.getCustomerType(), CustomerType.WOMAN);
    }
}