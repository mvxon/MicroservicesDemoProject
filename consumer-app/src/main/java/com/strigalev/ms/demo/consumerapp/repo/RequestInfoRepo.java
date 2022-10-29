package com.strigalev.ms.demo.consumerapp.repo;

import com.strigalev.ms.demo.consumerapp.domain.RequestInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RequestInfoRepo extends MongoRepository<RequestInfo, String> {
}
