package com.sentilabs.interviews.competentum;

import com.sentilabs.interviews.competentum.shop.Shop;
import com.sentilabs.interviews.competentum.customers.CustomerGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by sentipy on 22/03/15.
 */
public class Main {

    public static void main(String[] args) {
        if (args.length != 5 && args.length != 8){
            System.out.println("Parameters are: stepsToSimulate amountOfCashDesks minThroughputOfCashDesk"
                    + " maxThroughputOfCashDesk maxAmountOfGoodsForCustomer [manProcent womanProcent childProcent]");
            System.exit(0);
        }
        int argNumber = 0;
        int stepsToSimulate = Integer.parseInt(args[argNumber++]);
        int amountOfCashDesks = Integer.parseInt(args[argNumber++]);
        int minThroughputOfCashDesk = Integer.parseInt(args[argNumber++]);
        int maxThroughputOfCashDesk = Integer.parseInt(args[argNumber++]);
        int maxAmountOfGoodsForCustomer = Integer.parseInt(args[argNumber++]);
        int manProcent = 40;
        int womanProcent = 50;
        int childProcent = 40;
        if (args.length == 8){
            manProcent = Integer.parseInt(args[argNumber++]);
            womanProcent = Integer.parseInt(args[argNumber++]);
            childProcent = Integer.parseInt(args[argNumber++]);
        }
        List<Integer> throughputs = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < amountOfCashDesks; ++i){
            throughputs.add(minThroughputOfCashDesk + random.nextInt(maxThroughputOfCashDesk - minThroughputOfCashDesk + 1));
        }
        Shop shop = new Shop(throughputs, maxAmountOfGoodsForCustomer, new CustomerGenerator(manProcent, womanProcent, childProcent));
        for (int i = 0; i < stepsToSimulate; ++ i){
            shop.simulateStep();
        }
        shop.printState();
        /*while (true){
            shop.simulateStep();
            shop.printState();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {

            }
        }*/
    }
}
