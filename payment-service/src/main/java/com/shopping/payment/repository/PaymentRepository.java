package com.shopping.payment.repository;

import org.springframework.data.repository.CrudRepository;

import com.shopping.payment.model.PaymentDetail;

public interface PaymentRepository extends CrudRepository<PaymentDetail, String> {

}
