package com.car.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.car.models.Order;


@Repository
public interface IOrderRepository extends JpaRepository<Order, Long>{
	
	Order findByOrderId(long orderId);

}