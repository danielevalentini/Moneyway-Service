package com.betio.moneyway.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BaseReponse {
    private Boolean esit;
    private Object data;
    private String message;
}
