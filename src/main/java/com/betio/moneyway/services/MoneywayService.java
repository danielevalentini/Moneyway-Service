package com.betio.moneyway.services;


import com.betio.moneyway.dtos.MoneywayData;
import com.betio.moneyway.dtos.MoneywayMatch;
import com.betio.moneyway.model.MoneywayDataModel;
import com.betio.moneyway.model.MoneywayMatchModel;
import com.betio.moneyway.repository.MoneywayMatchRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class MoneywayService {

    @Autowired
    MoneywayMatchRepository moneywayMatchRepository;

    public MoneywayMatch getMatchById(String id){
        MoneywayMatchModel data = moneywayMatchRepository.findById(id).orElse( null );
        MoneywayMatch output = null;
        if (data!=null){
            output = MoneywayMatch.builder()
                    .away(data.getAway())
                    .home(data.getHome())
                    .key(id)
                    .start(data.getStart())
                    .dataList(data.getDataList().stream().map(m-> {
                        return MoneywayData.builder()
                                .oddAway(m.getOddAway())
                                .oddHome(m.getOddHome())
                                .oddDraw(m.getOddDraw())
                                .timestamp(m.getTimestamp())
                                .distributionHome(m.getDistributionHome())
                                .distributionDraw(m.getDistributionDraw())
                                .distributionAway(m.getDistributionAway())
                                .volume(m.getVolume())
                                .build();
                    }).collect(Collectors.toList()))
                    .build();
        }
        return output;
    }

    public void saveMatch(MoneywayMatch match) {

        MoneywayMatchModel matchFound = moneywayMatchRepository.findById(match.getKey()).orElse(null);

        if (matchFound==null){
            moneywayMatchRepository.save(
                MoneywayMatchModel.builder()
                        .home(match.getHome())
                        .away(match.getAway())
                        .key(match.getKey())
                        .start(match.getStart())
                        .dataList(match.getDataList().stream()
                                .map(m-> {
                                    return MoneywayDataModel.builder()
                                            .oddHome(m.getOddHome())
                                            .oddDraw(m.getOddDraw())
                                            .oddAway(m.getOddAway())
                                            .timestamp(m.getTimestamp())
                                            .volume(m.getVolume())
                                            .distributionHome(m.getDistributionHome())
                                            .distributionDraw(m.getDistributionDraw())
                                            .distributionAway(m.getDistributionAway())
                                            .build();
                                })
                                .collect(Collectors.toList()))
                        .build());
        }else{
            matchFound.getDataList().addAll(match.getDataList().stream()
                            .map(m->{
                                return MoneywayDataModel.builder()
                                        .oddHome(m.getOddHome())
                                        .oddDraw(m.getOddDraw())
                                        .oddAway(m.getOddAway())
                                        .timestamp(m.getTimestamp())
                                        .volume(m.getVolume())
                                        .distributionHome(m.getDistributionHome())
                                        .distributionDraw(m.getDistributionDraw())
                                        .distributionAway(m.getDistributionAway())
                                        .build();
                            }).collect(Collectors.toList()));
            moneywayMatchRepository.save(matchFound);
        }




    }
}
