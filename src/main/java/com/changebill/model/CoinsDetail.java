package com.changebill.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "coins_detail")
@Table
public class CoinsDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @Column(name = "ID")
    private Long id;

    @Column(name = "coin_type", unique = true)
    private double coinType;

    @Column(name = "coin_count")
    private int coinCount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getCoinType() {
        return coinType;
    }

    public void setCoinType(double coinType) {
        this.coinType = coinType;
    }

    public int getCoinCount() {
        return coinCount;
    }

    public void setCoinCount(int coinCount) {
        this.coinCount = coinCount;
    }

}
