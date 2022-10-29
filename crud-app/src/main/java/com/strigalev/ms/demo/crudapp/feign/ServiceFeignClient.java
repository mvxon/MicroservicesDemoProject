package com.strigalev.ms.demo.crudapp.feign;

import com.strigalev.ms.demo.crudapp.domain.RequestInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "consumer-app")
public interface ServiceFeignClient {

    @GetMapping("/usersRequestsInfo/{id}")
    RequestInfo getUserRequestInfo(@PathVariable String id);

    @GetMapping("/usersRequestsInfo")
    List<RequestInfo> getAllUsersRequestsInfo();
}