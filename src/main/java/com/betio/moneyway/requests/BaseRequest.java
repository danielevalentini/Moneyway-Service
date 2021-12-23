package com.betio.moneyway.requests;

import lombok.Data;
import lombok.ToString;


import java.io.Serializable;

@Data
@ToString
public abstract class BaseRequest implements Serializable {

    private String correlationId;
    private Long timestamp;
    private String channel;
}
