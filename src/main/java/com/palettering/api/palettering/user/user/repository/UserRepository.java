package com.palettering.api.palettering.user.user.repository;

import com.palettering.api.palettering.user.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {


    Optional<User> findByEmailAndPassword(String email, String password);

    //이미 회원가입되어 있는 이메일인지 확인
    Optional<User> findByEmail(String email);
}