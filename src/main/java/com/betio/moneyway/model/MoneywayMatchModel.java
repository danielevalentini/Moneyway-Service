package com.betio.moneyway.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Document(collection="moneywaymatchs")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class MoneywayMatchModel implements Serializable {

    @Id
    private String key;
    private String home;
    private String away;
    private Long start;

    private List<MoneywayDataModel> dataList;
}
