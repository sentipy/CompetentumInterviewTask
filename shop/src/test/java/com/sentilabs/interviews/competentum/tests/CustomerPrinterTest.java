package com.sentilabs.interviews.competentum.tests;

import com.sentilabs.interviews.competentum.customers.Customer;
import com.sentilabs.interviews.competentum.customers.types.CustomerType;
import com.sentilabs.interviews.competentum.printers.CustomerPrinter;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerPrinterTest {

    @Test
    public void testPrint() throws Exception {
        final Customer customer = new Customer(10, CustomerType.CHILD);
        customer.reduceAmountInHands(2);
        Assert.assertEquals(new CustomerPrinter().print(customer)
                , "[C-8/10]");
    }
}