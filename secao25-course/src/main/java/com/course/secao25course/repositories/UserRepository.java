package com.course.secao25course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.course.secao25course.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
