package com.course.secao25course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.course.secao25course.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
