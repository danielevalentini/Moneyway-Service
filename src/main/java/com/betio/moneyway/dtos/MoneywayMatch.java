package com.betio.moneyway.dtos;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MoneywayMatch implements Serializable {

    private String key;
    private String home;
    private String away;
    private Long start;

    private List<MoneywayData> dataList;
}
