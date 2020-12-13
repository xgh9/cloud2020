package com.xing.springcloud.controller;

import com.xing.springcloud.entities.JsonResponse;
import com.xing.springcloud.entities.Payment;
import com.xing.springcloud.service.PaymentService;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class FeignOrderController {

    @Resource
    PaymentService paymentService;

    @PostMapping("/feign/create")
    public JsonResponse create(@RequestBody Payment payment){
        return paymentService.create(payment);
    }

    @GetMapping("/feign/get/{id}")
    public JsonResponse getPaymentById(@PathVariable("id") long id){
        return paymentService.getPaymentById(id);
    }

    @GetMapping("/feign/timeOut")
    public JsonResponse timeOut(){
        return paymentService.timeOut();
    }
}
