package com.course.secao25course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.course.secao25course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
