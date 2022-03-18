package com.changebill;

import com.changebill.model.CoinsDetail;
import com.changebill.repository.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@EnableCaching
@SpringBootApplication
public class ChangeBillApplication {

    @Value("${app.coins}")
    private String coins;

    @Autowired
    private CoinRepository coinRepository;


    public static void main(String[] args) {
        SpringApplication.run(ChangeBillApplication.class, args);
    }

    @Bean
    InitializingBean sendDatabase() {
        Integer coin = Integer.valueOf(coins);
        CoinsDetail penny = new CoinsDetail();
        penny.setCoinCount(coin);
        penny.setCoinType(0.01);
        CoinsDetail nickel = new CoinsDetail();
        nickel.setCoinCount(coin);
        nickel.setCoinType(0.05);
        CoinsDetail dime = new CoinsDetail();
        dime.setCoinCount(coin);
        dime.setCoinType(0.10);
        CoinsDetail quarter = new CoinsDetail();
        quarter.setCoinCount(coin);
        quarter.setCoinType(0.25);
        return () -> {
            coinRepository.updateCounts(0.01, coin);
            coinRepository.updateCounts(0.05, coin);
            coinRepository.updateCounts(0.10, coin);
            coinRepository.updateCounts(0.25, coin);
        };
    }
}
