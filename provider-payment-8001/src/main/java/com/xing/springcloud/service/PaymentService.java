package com.xing.springcloud.service;

import com.xing.springcloud.entities.JsonResponse;
import com.xing.springcloud.entities.Payment;
import com.xing.springcloud.mapper.PaymentMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSON;

import javax.annotation.Resource;

@Service
@Slf4j
public class PaymentService {
    @Resource
    PaymentMapper paymentMapper;
    @Value("${server.port}")
    String port;

    public JsonResponse insert(Payment payment){
        int result = paymentMapper.insert(payment);
        if (result > 0){
            log.info("insert payment success");
            return JsonResponse.success();
        }
        return JsonResponse.error(444,"插入数据库失败");
    }

    public JsonResponse getPaymentById(Long id){
        Payment payment = paymentMapper.getPaymentById(id);
        JsonResponse response = JsonResponse.success();
        response.put("data",JSON.toJSON(payment));
        response.put("port",port);
        return response;
    }
}
