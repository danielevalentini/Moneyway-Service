package com.betio.moneyway.model;

import lombok.*;

import java.math.BigDecimal;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MoneywayDataModel {


    private Long timestamp;

    private BigDecimal oddHome;
    private BigDecimal oddDraw;
    private BigDecimal oddAway;

    private BigDecimal distributionHome;
    private BigDecimal distributionDraw;
    private BigDecimal distributionAway;

    private BigDecimal volume;
}
