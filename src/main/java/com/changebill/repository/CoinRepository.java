package com.changebill.repository;

import javax.transaction.Transactional;

import com.changebill.model.CoinsDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface CoinRepository extends JpaRepository<CoinsDetail, Long> {

    @Modifying
    @Transactional
    @Query("update coins_detail set coin_count = ?2 where coin_type = ?1")
    void updateCounts(@Param(value = "coin_type") double coinType, @Param(value = "coin_count") int coinCount);

}
