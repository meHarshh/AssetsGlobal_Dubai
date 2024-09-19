package com.asg.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asg.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
