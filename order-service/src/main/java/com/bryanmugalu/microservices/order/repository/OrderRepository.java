package com.bryanmugalu.microservices.order.repository;

import com.bryanmugalu.microservices.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}