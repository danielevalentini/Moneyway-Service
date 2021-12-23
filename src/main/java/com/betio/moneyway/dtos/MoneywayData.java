package com.betio.moneyway.dtos;

import lombok.*;

import java.math.BigDecimal;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class MoneywayData {


    private Long timestamp;

    private BigDecimal oddHome;
    private BigDecimal oddDraw;
    private BigDecimal oddAway;

    private BigDecimal distributionHome;
    private BigDecimal distributionDraw;
    private BigDecimal distributionAway;

    private BigDecimal volume;
}
