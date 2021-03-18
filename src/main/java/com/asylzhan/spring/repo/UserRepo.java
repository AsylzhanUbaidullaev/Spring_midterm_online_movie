package com.asylzhan.spring.repo;

import com.asylzhan.spring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    User getUserByEmailAndPassword(String email, String password);
    User getUserByEmail(String email);
}
