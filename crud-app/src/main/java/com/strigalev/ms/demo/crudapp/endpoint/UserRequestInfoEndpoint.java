package com.strigalev.ms.demo.crudapp.endpoint;

import com.strigalev.ms.demo.crudapp.domain.RequestInfo;
import com.strigalev.ms.demo.crudapp.feign.ServiceFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/usersRequests")
public class UserRequestInfoEndpoint {
    private final ServiceFeignClient serviceFeignClient;

    @GetMapping("/{id}")
    public ResponseEntity<RequestInfo> getById(@PathVariable Long id) {
        return ResponseEntity.ok(serviceFeignClient.getUserRequestInfo(id.toString()));
    }

    @GetMapping
    public ResponseEntity<List<RequestInfo>> getAll() {
        return ResponseEntity.ok(serviceFeignClient.getAllUsersRequestsInfo());
    }

}
