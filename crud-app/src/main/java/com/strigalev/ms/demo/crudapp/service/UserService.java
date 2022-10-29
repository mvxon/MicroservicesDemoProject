package com.strigalev.ms.demo.crudapp.service;

import com.strigalev.ms.demo.crudapp.domain.RequestInfo;
import com.strigalev.ms.demo.crudapp.domain.User;
import com.strigalev.ms.demo.crudapp.feign.ServiceFeignClient;
import com.strigalev.ms.demo.crudapp.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class UserService {

    private final static String PATH = "/api/v1/users";
    @Value("${spring.rabbitmq.template.exchange}")
    private String exchange;
    @Value("${spring.rabbitmq.template.routingkey}")
    private String routingkey;

    private final RabbitTemplate rabbitTemplate;
    private final UserRepo userRepo;
    private final ServiceFeignClient serviceFeignClient;

    public User getById(Long id) {
        var user = userRepo.findById(id).orElseThrow(() -> new RuntimeException("NOT FOUND"));
        sendRequestInfo("GET", user.getId());
        return user;
    }

    @Transactional
    public Long save(User user) {
        var savedUser = userRepo.save(user);
        sendRequestInfo("POST", savedUser.getId());
        return savedUser.getId();
    }

    public void sendRequestInfo(String httpMethod, Long userId) {
        rabbitTemplate.convertAndSend(
                exchange,
                routingkey,
                RequestInfo.builder()
                        .requestDate(LocalDate.now().toString())
                        .requestPath(PATH)
                        .userId(userId)
                        .httpMethodType(httpMethod)
                        .build()
        );
    }

    @Transactional
    public void deleteById(Long id) {
        userRepo.deleteById(id);
        sendRequestInfo("DELETE", id);
    }

    @Transactional
    public void updateUser(User user) {
        userRepo.save(user);
        sendRequestInfo("PUT", user.getId());
    }
}
