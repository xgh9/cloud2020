package com.xing.springcloud.controller;

import com.xing.springcloud.entities.JsonResponse;
import com.xing.springcloud.entities.Payment;
import com.xing.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @PostMapping("/payment/create")
    public JsonResponse create(@RequestBody Payment payment){
        return paymentService.insert(payment);
    }

    @GetMapping("/payment/get/{id}")
    public JsonResponse getPaymentById(@PathVariable("id") long id){
        System.out.println(2);
        return paymentService.getPaymentById(id);
    }
}
