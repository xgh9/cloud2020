package com.xing.springcloud.mapper;

import com.xing.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentMapper {
    int insert(Payment payment);

    Payment getPaymentById(long id);
}
