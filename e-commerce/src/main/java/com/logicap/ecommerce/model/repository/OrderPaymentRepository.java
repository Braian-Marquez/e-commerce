package com.logicap.ecommerce.model.repository;

import com.logicap.ecommerce.model.entity.OrderPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderPaymentRepository extends JpaRepository<OrderPayment,Long> {
}
