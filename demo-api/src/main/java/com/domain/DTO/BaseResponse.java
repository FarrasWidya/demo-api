package com.domain.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class BaseResponse<T> {
    @JsonProperty("status")
    private boolean status;
    @JsonProperty("message")
    private String message;
    @JsonProperty("result")
    private Object result;

//    private Object result;

}
