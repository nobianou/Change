package com.changebill.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CoinsDetailTest {
    @Test
    void testConstructor() {
        CoinsDetail actualCoinsDetail = new CoinsDetail();
        actualCoinsDetail.setCoinCount(3);
        actualCoinsDetail.setCoinType(10.0);
        actualCoinsDetail.setId(123L);
        assertEquals(3, actualCoinsDetail.getCoinCount());
        assertEquals(10.0, actualCoinsDetail.getCoinType());
        assertEquals(123L, actualCoinsDetail.getId().longValue());
    }
}

