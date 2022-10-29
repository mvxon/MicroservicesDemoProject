package com.strigalev.ms.demo.crudapp.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestInfo {
    private String requestDate;
    private String requestPath;
    private Long userId;
    private String httpMethodType;
}
