package com.shinedeer.springboot.repository;

import com.shinedeer.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Calvin Hwang
 * 2018/12/19 21:40
 * User 仓库层
 */
public interface UserRepository extends JpaRepository<User, Integer> {
}
