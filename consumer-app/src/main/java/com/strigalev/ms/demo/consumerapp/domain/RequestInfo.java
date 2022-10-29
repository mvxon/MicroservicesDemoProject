package com.strigalev.ms.demo.consumerapp.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("users")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestInfo {
    @Id
    private String id;
    private String requestDate;
    private String requestPath;
    private Long userId;
    private String httpMethodType;
}
