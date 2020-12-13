package com.xing.springcloud.service;

import com.xing.springcloud.entities.JsonResponse;
import com.xing.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@FeignClient("PAYMENT-SERVICE")
public interface PaymentService {
    @PostMapping("/payment/create")
    JsonResponse create(@RequestBody Payment payment);

    @GetMapping("/payment/get/{id}")
    JsonResponse getPaymentById(@PathVariable("id") long id);

    @GetMapping("/payment/timeOut")
    public JsonResponse timeOut();
}
