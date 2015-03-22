package com.sentilabs.interviews.competentum.tests;

import com.sentilabs.interviews.competentum.customers.CustomerGenerator;
import com.sentilabs.interviews.competentum.shop.CashDesk;
import com.sentilabs.interviews.competentum.shop.Shop;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ShopTest {

    @Test(expected = IllegalArgumentException.class)
    public void testSimulateStepIllegalMaxAmount() throws Exception {
        final Shop shop = new Shop(Arrays.asList(5, 7, 3), -100, new CustomerGenerator(40, 50, 10));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSimulateStepIllegalAmountOfCashDesks() throws Exception {
        final Shop shop = new Shop(Arrays.asList(), 100, new CustomerGenerator(40, 50, 10));
    }

    @Test
    public void testSimulateStep() throws Exception {
        final Shop shop = new Shop(Arrays.asList(5, 7, 3), 100, new CustomerGenerator(40, 50, 10));
        outer:
        for (int i = 0; i < 1000; ++i){
            shop.simulateStep();
            final Iterable<CashDesk> cashDesks = shop.getCashDesks();
            for (CashDesk cashDesk : cashDesks) {
                if (cashDesk.getCustomers().iterator().hasNext()){
                    break outer;
                }
            }
        }
    }
}