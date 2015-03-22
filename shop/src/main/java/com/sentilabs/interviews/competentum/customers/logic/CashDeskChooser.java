package com.sentilabs.interviews.competentum.customers.logic;

import com.sentilabs.interviews.competentum.customers.ICustomer;
import com.sentilabs.interviews.competentum.shop.CashDesk;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.function.ToDoubleFunction;

/**
 * Created by sentipy on 22/03/15.
 */
public class CashDeskChooser {

    private static CashDesk manLogic(List<CashDesk> cashDesks, ICustomer customer){
        final Iterator<CashDesk> iterator = cashDesks.iterator();
        CashDesk bestCashDesk = iterator.next();
        ToDoubleFunction<ICustomer> sumOfInitialAmounts = __customer -> __customer.getInitialAmountInHands();
        int bestStepsToFinish = (int) Math.ceil(bestCashDesk.getQueue()
                .stream()
                .mapToDouble(sumOfInitialAmounts)
                .sum() / bestCashDesk.getThroughput())
                + (int) Math.ceil(customer.getInitialAmountInHands() / bestCashDesk.getThroughput());
        while (iterator.hasNext()){
            CashDesk currentCashDesk = iterator.next();
            int stepsToFinish = (int) Math.ceil(currentCashDesk.getQueue()
                    .stream()
                    .mapToDouble(sumOfInitialAmounts).sum() / currentCashDesk.getThroughput())
                    + (int) Math.ceil(customer.getInitialAmountInHands() / currentCashDesk.getThroughput());
            if (stepsToFinish < bestStepsToFinish){
                bestStepsToFinish = stepsToFinish;
                bestCashDesk = currentCashDesk;
            }

        }
        return bestCashDesk;
    }

    private static CashDesk womanLogic(List<CashDesk> cashDesks){
        final Iterator<CashDesk> iterator = cashDesks.iterator();
        CashDesk bestCashDesk = iterator.next();
        while (iterator.hasNext()){
            CashDesk currentCashDesk = iterator.next();
            if (currentCashDesk.getQueue().size() < bestCashDesk.getQueue().size()){
                bestCashDesk = currentCashDesk;
            }
        }
        return bestCashDesk;
    }

    private static CashDesk childLogic(List<CashDesk> cashDesks){
        Random random = new Random();
        int cashDeskNumber = random.nextInt(cashDesks.size());
        return cashDesks.get(cashDeskNumber);
    }

    public static CashDesk chooseCashDesk(List<CashDesk> cashDesks, ICustomer customer){
        switch (customer.getCustomerType()){
            case MAN:
                return manLogic(cashDesks, customer);
            case WOMAN:
                return womanLogic(cashDesks);
            case CHILD:
                return childLogic(cashDesks);
            default:
                throw new RuntimeException("Unknown type of customer: " + customer.getCustomerType());
        }
    }
}
