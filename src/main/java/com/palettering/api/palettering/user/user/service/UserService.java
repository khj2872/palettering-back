package com.palettering.api.palettering.user.user.service;

import com.palettering.api.core.response.Response;
import com.palettering.api.palettering.user.user.domain.User;
import com.palettering.api.palettering.user.user.repository.UserRepository;
import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import static com.palettering.api.core.util.JwtUtil.createToken;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    // User Signup
    public User userSignUp(User user) {
        return userRepository.save(user);
    }

    // Login
    public User login(String email, String password) {
        System.out.println("password ->" + password);
        User user = userRepository.findByEmailAndPassword(email, password).orElse(User.builder().build());
        if(user.getEmail() != null && user.getPassword() != null) {
            System.out.println("로그인 성공");
            //Generate JWT Token
            System.out.println(createToken(user));
        } else {
            System.out.println("로그인 실패");
            return null;
        }

//        if(ObjectUtils.isEmpty(user)) {
//            System.out.println("로그인 실패");
//        } else {
//            System.out.println("로그인 성공");
//        }

        return user;
    }

    // 이미 회원가입되어 있는 이메일인지 확인
    public boolean isExistingEmail(String email) {
        User user = userRepository.findByEmail(email).orElse(User.builder().build());
//        Q. return ObjectUtils.isEmpty(user) ? false : true;  //이거 자꾸 NOT EMPTY라고 하는데 왜그러지..?
        return user.getEmail() == null ? false : true;
    };
}
