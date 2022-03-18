package com.changebill.util;

import java.util.List;

import com.changebill.model.CoinsDetail;

public class ChangeRequestorUtils {

	public static double availableAmount(List<CoinsDetail> coinsDetails) {
		double availableAmount = 0;
		for (CoinsDetail c : coinsDetails) {
			availableAmount = availableAmount + (c.getCoinType() * c.getCoinCount());
		}
		return availableAmount;
	}

}
