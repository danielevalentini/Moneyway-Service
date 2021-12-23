package com.betio.moneyway.controllers;


import com.betio.moneyway.dtos.MoneywayMatch;
import com.betio.moneyway.producers.MoneyMatchProducer;
import com.betio.moneyway.responses.BaseReponse;
import com.betio.moneyway.services.MoneywayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@Slf4j
public class MoneywayController {

    @Autowired
    MoneywayService service;
    @Autowired
    MoneyMatchProducer moneyMatchProducerService;

    @GetMapping("/moneyway/{id}")
    public ResponseEntity<?> get(@PathVariable("id") String key){
        log.info("Enter in MoneywayController.get({})",key);
        MoneywayMatch match = service.getMatchById(key);
        log.info("Exit from MoneywayController.get({}) Response: {}",key,match);
        return ResponseEntity.ok(new BaseReponse(true, match , "SUCCESS"));
    }

    @PostMapping("/moneyway")
    public ResponseEntity<?> save(@RequestBody MoneywayMatch match){
        log.info("Enter in MoneywayController.save({})",match);

        moneyMatchProducerService.send(match);

        //service.saveMatch(match);
        log.info("Exit from MoneywayController.save({}) Response: {}",match,match.getKey());
        return ResponseEntity.ok(new BaseReponse(true, match.getKey() , "SUCCESS"));
    }

}
