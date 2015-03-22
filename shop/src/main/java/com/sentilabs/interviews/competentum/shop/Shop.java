package com.sentilabs.interviews.competentum.shop;

import com.sentilabs.interviews.competentum.customers.logic.CashDeskChooser;
import com.sentilabs.interviews.competentum.printers.CustomerPrinter;
import com.sentilabs.interviews.competentum.customers.CustomerGenerator;
import com.sentilabs.interviews.competentum.customers.ICustomer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by sentipy on 22/03/15.
 */
public class Shop {

    private final List<CashDesk> cashDesks = new ArrayList<>();
    private final int maxAmountInHands;
    private final CustomerGenerator customerGenerator;

    public Shop(List<Integer> throughputs, int maxAmountInHands, CustomerGenerator customerGenerator) {
        if (throughputs.size() < 1){
            throw new IllegalArgumentException("Number of cash desks must positive");
        }
        if (maxAmountInHands < 1){
            throw new IllegalArgumentException("Number of maxAmountInHands must positive");
        }
        this.maxAmountInHands = maxAmountInHands;
        cashDesks.addAll(throughputs.stream().map(CashDesk::new).collect(Collectors.toList()));
        this.customerGenerator = customerGenerator;

    }

    public Iterable<CashDesk> getCashDesks(){
        return this.cashDesks;
    }

    public void simulateStep(){
        ICustomer customer = customerGenerator.generateCustomer(maxAmountInHands);
        CashDeskChooser.chooseCashDesk(this.cashDesks, customer).getQueue().add(customer);
        cashDesks.forEach(CashDesk::step);

    }

    public void printState(){
        CustomerPrinter customerPrinter = new CustomerPrinter();
        int i = 1;
        System.out.print("===================================");
        for (CashDesk cashDesk : cashDesks) {
            System.out.println();
            System.out.print(i + " (" + cashDesk.getThroughput() + ")" + " <- ");
            if (cashDesk.getQueue().size() > 0){
                final Iterator<ICustomer> iterator = cashDesk.getQueue().iterator();
                ICustomer customer = iterator.next();
                String print = customerPrinter.print(customer);
                System.out.print(print);
                while (iterator.hasNext()){
                    customer = iterator.next();
                    print = customerPrinter.print(customer);
                    System.out.print(", " + print);
                }
            }
            ++i;
        }
        System.out.println();
        System.out.println("===================================");
    }
}
