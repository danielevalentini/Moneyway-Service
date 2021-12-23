package com.betio.moneyway.consumers;

import com.betio.moneyway.dtos.MoneywayMatch;
import com.betio.moneyway.services.MoneywayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MoneyMatchConsumer {

    @Autowired
    MoneywayService moneywayService;

    @KafkaListener(groupId = "betio-moneyway",topics = "betio-topic-moneyway")
    public void consume(MoneywayMatch message){

        log.info("Message received -> {}",message);
        moneywayService.saveMatch(message);
        log.info("Message saved -> {}",message);
    }
}
