package com.changebill.service;

import com.changebill.exception.ChangeBillException;
import com.changebill.model.CoinsDetail;
import com.changebill.model.CoinsTray;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ChangeCalculatorService {

	CoinsTray calculateChangeForABill(double bill, boolean minCoin) throws ChangeBillException;

}
