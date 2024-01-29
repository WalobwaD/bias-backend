package com.Housing.Bias.repository;

import com.Housing.Bias.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByUserid(Long userid);
}
