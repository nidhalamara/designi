package com.designi.desiginibackend.impl.dal;

import com.designi.desiginibackend.impl.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,String> {

    Optional<User> findUserByEmail(String email);


}
