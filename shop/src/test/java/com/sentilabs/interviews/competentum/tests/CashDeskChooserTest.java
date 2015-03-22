package com.sentilabs.interviews.competentum.tests;


import com.sentilabs.interviews.competentum.customers.Customer;
import com.sentilabs.interviews.competentum.customers.logic.CashDeskChooser;
import com.sentilabs.interviews.competentum.customers.types.CustomerType;
import com.sentilabs.interviews.competentum.shop.CashDesk;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CashDeskChooserTest {

    @org.junit.Test
    public void testChooseCashDeskForChildOneCashDesk() throws Exception {
        List<CashDesk> cashDesks = new ArrayList<>();
        CashDesk cashDesk = new CashDesk(10);
        cashDesks.add(cashDesk);

        CashDesk chosenCashDesk = CashDeskChooser.chooseCashDesk(cashDesks, new Customer(10, CustomerType.CHILD));
        Assert.assertEquals(chosenCashDesk, cashDesk);
    }

    @org.junit.Test
    public void testChooseCashDeskForChild() throws Exception {
        List<CashDesk> cashDesks = new ArrayList<>();
        CashDesk cashDesk = new CashDesk(10);
        cashDesks.add(cashDesk);

        cashDesk = new CashDesk(20);
        cashDesks.add(cashDesk);

        CashDesk chosenCashDesk = CashDeskChooser.chooseCashDesk(cashDesks, new Customer(10, CustomerType.CHILD));
        Assert.assertTrue(cashDesks.contains(chosenCashDesk));
    }

    @org.junit.Test
    public void testChooseCashDeskForWoman1() throws Exception {
        List<CashDesk> cashDesks = new ArrayList<>();
        CashDesk cashDesk = new CashDesk(10);
        cashDesk.getQueue().add(new Customer(10, CustomerType.WOMAN));
        cashDesks.add(cashDesk);

        cashDesk = new CashDesk(20);
        cashDesks.add(cashDesk);

        CashDesk chosenCashDesk = CashDeskChooser.chooseCashDesk(cashDesks, new Customer(10, CustomerType.WOMAN));
        Assert.assertEquals(chosenCashDesk, cashDesk);
    }

    @org.junit.Test
    public void testChooseCashDeskForWoman2() throws Exception {
        List<CashDesk> cashDesks = new ArrayList<>();
        CashDesk cashDesk1 = new CashDesk(10);
        cashDesks.add(cashDesk1);

        CashDesk cashDesk2 = new CashDesk(20);
        cashDesks.add(cashDesk2);

        int random = new Random().nextInt(2);
        cashDesks.get(random).getQueue().add(new Customer(10, CustomerType.WOMAN));

        CashDesk chosenCashDesk = CashDeskChooser.chooseCashDesk(cashDesks, new Customer(10, CustomerType.WOMAN));
        Assert.assertEquals(chosenCashDesk, cashDesks.get(1 - random));
    }

    @org.junit.Test
    public void testChooseCashDeskForMan() throws Exception {
        List<CashDesk> cashDesks = new ArrayList<>();
        CashDesk cashDesk = new CashDesk(10);
        cashDesk.getQueue().add(new Customer(10, CustomerType.WOMAN));
        cashDesks.add(cashDesk);

        cashDesk = new CashDesk(20);
        cashDesks.add(cashDesk);

        CashDesk chosenCashDesk = CashDeskChooser.chooseCashDesk(cashDesks, new Customer(10, CustomerType.MAN));
        Assert.assertEquals(chosenCashDesk, cashDesk);
    }

    @org.junit.Test
    public void testChooseCashDeskForMan2() throws Exception {
        List<CashDesk> cashDesks = new ArrayList<>();
        CashDesk cashDesk = new CashDesk(10);
        cashDesk.getQueue().add(new Customer(10, CustomerType.WOMAN));
        cashDesks.add(cashDesk);

        cashDesk = new CashDesk(1);
        cashDesks.add(cashDesk);

        CashDesk chosenCashDesk = CashDeskChooser.chooseCashDesk(cashDesks, new Customer(10, CustomerType.MAN));
        Assert.assertEquals(chosenCashDesk, cashDesks.get(0));
    }
}