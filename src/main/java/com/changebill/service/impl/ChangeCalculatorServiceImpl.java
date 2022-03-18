package com.changebill.service.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import com.changebill.exception.ChangeBillException;
import com.changebill.model.Coins;
import com.changebill.model.CoinsDetail;
import com.changebill.model.CoinsTray;
import com.changebill.repository.CoinRepository;
import com.changebill.service.ChangeCalculatorService;
import com.changebill.util.ChangeRequestorConstants;
import com.changebill.util.ChangeRequestorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ChangeCalculatorServiceImpl implements ChangeCalculatorService {

    @Autowired
    public CoinRepository coinRepository;

    @Override
    public CoinsTray calculateChangeForABill(double bill, boolean minCoins) throws ChangeBillException {

        boolean contains = ChangeRequestorConstants.availableBills.contains((int) bill);

        CoinsTray coinsTray = new CoinsTray();

        if (contains) {
            List<CoinsDetail> coinsAvailable = coinRepository.findAll();
            // Map to have type of coins as Key and no of coins as Values
            Map<Double, Integer> map = coinsAvailable.stream()
                    .collect(Collectors.toMap(CoinsDetail::getCoinType, CoinsDetail::getCoinCount));
            // Total amount based on available coins
            double availableAmount = ChangeRequestorUtils.availableAmount(coinsAvailable);
            if (availableAmount < bill) {
                throw new ChangeBillException("Not enough coins available for " + bill + " 's  bill ");
            }
            List<Coins> coins = coinsTray.getCoins();
            // Retrieved values of each type of Coins
            int availableQuarters = map.get(ChangeRequestorConstants.QUARTER);
            int availableDimes = map.get(ChangeRequestorConstants.DIME);
            int availableNickels = map.get(ChangeRequestorConstants.NICKEL);
            int availablePennies = map.get(ChangeRequestorConstants.PENNY);

            if (minCoins) {
                bill = getChange(bill, coins, availableQuarters, ChangeRequestorConstants.QUARTER);
                bill = getChange(bill, coins, availableDimes, ChangeRequestorConstants.DIME);
                bill = getChange(bill, coins, availableNickels, ChangeRequestorConstants.NICKEL);
                bill = getChange(bill, coins, availablePennies, ChangeRequestorConstants.PENNY);
            } else {
                bill = getChange(bill, coins, availablePennies, ChangeRequestorConstants.PENNY);
                bill = getChange(bill, coins, availableNickels, ChangeRequestorConstants.NICKEL);
                bill = getChange(bill, coins, availableDimes, ChangeRequestorConstants.DIME);
                bill = getChange(bill, coins, availableQuarters, ChangeRequestorConstants.QUARTER);

            }
            coinsTray.setCoins(coins);
        } else {
            throw new ChangeBillException("Bill of " + bill + " is not in available Bills ");
        }

        return coinsTray;
    }


    private double getChange(double bill, List<Coins> coins, int availableCoins, double type) {
        int quot;
        if (availableCoins > 0) {
            quot = (int) (bill / type);
            int updatedCoins = (availableCoins - quot);
            if (quot != 0) {
                if (updatedCoins <= 0) {
                    quot = availableCoins;
                    updatedCoins = 0;
                }
                bill = bill - (type * Double.valueOf(quot));
                Coins quarter = new Coins(type, quot);
                coins.add(quarter);
                if (quot >= 0)
                    coinRepository.updateCounts(type, updatedCoins);
            }
        }
        return bill; //Remaining bill
    }

}
