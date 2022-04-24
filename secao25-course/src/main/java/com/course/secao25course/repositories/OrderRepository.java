package com.course.secao25course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.course.secao25course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
