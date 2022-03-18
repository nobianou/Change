package com.changebill.controller;

import com.changebill.exception.ChangeBillException;
import com.changebill.model.CoinsTray;
import com.changebill.service.ChangeCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/bill")
public class ChangeBillController {

	@Autowired
	private ChangeCalculatorService service;

	@GetMapping("/{bill}/{minCoin}")
	public ResponseEntity<CoinsTray> getChange(@PathVariable int bill, @PathVariable String minCoin) {
		try {
			return new ResponseEntity<CoinsTray>(service.calculateChangeForABill(bill,Boolean.valueOf(minCoin)), HttpStatus.OK);
		} catch (ChangeBillException e) {
			throw new ChangeBillException(e.getMessage());
		}

	}


}
