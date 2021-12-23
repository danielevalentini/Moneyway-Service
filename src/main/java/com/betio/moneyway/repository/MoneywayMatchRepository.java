package com.betio.moneyway.repository;


import com.betio.moneyway.model.MoneywayMatchModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoneywayMatchRepository extends MongoRepository<MoneywayMatchModel,String> {
}
