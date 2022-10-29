package com.strigalev.ms.demo.consumerapp.endpoint;


import com.strigalev.ms.demo.consumerapp.domain.RequestInfo;
import com.strigalev.ms.demo.consumerapp.repo.RequestInfoRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usersRequestsInfo")
public class RequestInfoEndpoint {
    private final RequestInfoRepo requestInfoRepo;

    @GetMapping("/{id}")
    public RequestInfo getUserRequestInfo(@PathVariable String id) {
        return requestInfoRepo.findById(id).orElseThrow(() -> new RuntimeException("NOT FOUND"));
    }

    @GetMapping
    public List<RequestInfo> getAllUsersRequestsInfo() {
        return requestInfoRepo.findAll();
    }

}
