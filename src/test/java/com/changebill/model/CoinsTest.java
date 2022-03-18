package com.changebill.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CoinsTest {
    @Test
    void testConstructor() {
        Coins actualCoins = new Coins(10.0, 1);
        actualCoins.setCoin(10.0);
        actualCoins.setNoOfCoins(1);
        assertEquals(10.0, actualCoins.getCoin());
        assertEquals(1, actualCoins.getNoOfCoins());
    }

}

