package com.xing.springcloud.controller;

import com.xing.springcloud.entities.JsonResponse;
import com.xing.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class OrderController {
    public static final String PAYMENT_URL = "http://PAYMENT-SERVICE";
    @Resource
    RestTemplate restTemplate;

    @Resource
    DiscoveryClient discoveryClient;

    @PostMapping("/consumer/payment/create")
    public JsonResponse create(@RequestBody Payment payment){
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, JsonResponse.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public JsonResponse getPaymentById(@PathVariable("id") long id){
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, JsonResponse.class);
    }
}
