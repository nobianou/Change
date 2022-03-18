package com.changebill.service.impl;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.changebill.exception.ChangeBillException;
import com.changebill.model.CoinsDetail;
import com.changebill.repository.CoinRepository;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ChangeCalculatorServiceImpl.class})
@ExtendWith(SpringExtension.class)
class ChangeCalculatorServiceImplTest {
    @Autowired
    private ChangeCalculatorServiceImpl changeCalculatorServiceImpl;

    @MockBean
    private CoinRepository coinRepository;


    @Test
    void testCalculateChangeForABill() throws ChangeBillException {
        CoinsDetail coinsDetail = new CoinsDetail();
        coinsDetail.setCoinType(0.0);
        coinsDetail.setId(123L);
        coinsDetail.setCoinCount(3);

        ArrayList<CoinsDetail> coinsDetailList = new ArrayList<>();
        coinsDetailList.add(coinsDetail);
        when(this.coinRepository.findAll()).thenReturn(coinsDetailList);
        assertThrows(ChangeBillException.class, () -> this.changeCalculatorServiceImpl.calculateChangeForABill(10.0, true));
        verify(this.coinRepository).findAll();
    }
}

