package com.sentilabs.interviews.competentum.tests;

import com.sentilabs.interviews.competentum.customers.Customer;
import com.sentilabs.interviews.competentum.customers.types.CustomerType;
import com.sentilabs.interviews.competentum.shop.CashDesk;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CashDeskTest {

    @Test
    public void testGetThroughput() throws Exception {
        Assert.assertEquals(new CashDesk(10).getThroughput(), 10);
    }

    @Test
    public void testGetQueue() throws Exception {
        Assert.assertTrue(new CashDesk(10).getQueue().size() == 0);
    }

    @Test
    public void testStep() throws Exception {
        CashDesk cashDesk = new CashDesk(7);
        Customer customer = new Customer(20, CustomerType.CHILD);
        cashDesk.getQueue().add(customer);
        cashDesk.step();
        Assert.assertEquals(customer.getAmountInHands(), 13);
        cashDesk.step();
        Assert.assertEquals(customer.getAmountInHands(), 6);
        cashDesk.step();
        Assert.assertEquals(customer.getAmountInHands(), 0);
        Assert.assertTrue(cashDesk.getQueue().isEmpty());
        cashDesk.step();
    }
}