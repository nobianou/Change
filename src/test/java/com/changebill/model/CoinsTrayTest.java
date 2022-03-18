package com.changebill.model;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class CoinsTrayTest {
    @Test
    void testGetCoins() {
        CoinsTray coinsTray = new CoinsTray();
        List<Coins> actualCoins = coinsTray.getCoins();
        assertSame(coinsTray.coins, actualCoins);
        assertTrue(actualCoins.isEmpty());
        assertSame(actualCoins, coinsTray.coins);
    }

    @Test
    void testConstructor() {
        CoinsTray actualCoinsTray = new CoinsTray();
        ArrayList<Coins> coinsList = new ArrayList<>();
        actualCoinsTray.setCoins(coinsList);
        List<Coins> coins = actualCoinsTray.getCoins();
        assertSame(coinsList, coins);
        assertTrue(coins.isEmpty());
        assertSame(coins, actualCoinsTray.coins);
        assertSame(coins, coinsList);
    }
}

