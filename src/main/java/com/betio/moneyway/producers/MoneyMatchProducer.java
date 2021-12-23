package com.betio.moneyway.producers;

import com.betio.moneyway.dtos.MoneywayMatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MoneyMatchProducer {

    @Autowired
    KafkaTemplate<String, MoneywayMatch > kafkaTemplate;

    public String send(MoneywayMatch moneywayMatch){
        kafkaTemplate.send("betio-topic-moneyway",moneywayMatch);
        return moneywayMatch.getKey();
    }
}
