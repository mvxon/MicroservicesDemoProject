package com.strigalev.ms.demo.consumerapp.service;

import com.strigalev.ms.demo.consumerapp.domain.RequestInfo;
import com.strigalev.ms.demo.consumerapp.repo.RequestInfoRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RequestInfoService {

    private final RequestInfoRepo requestInfoRepo;
    private static Long ID = 0L;

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void receivedMessage(RequestInfo requestInfo) {
        requestInfo.setId((ID++).toString());
        requestInfoRepo.save(requestInfo);
    }
}
