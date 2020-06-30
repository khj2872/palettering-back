package com.palettering.api.palettering.user.user.controller;

import com.palettering.api.palettering.user.user.domain.User;
import com.palettering.api.palettering.user.user.service.UserQueryService;
import com.palettering.api.palettering.user.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.palettering.api.core.util.JwtUtil.createToken;

@RequiredArgsConstructor

@RestController
@RequestMapping("/api/v1/member")
public class UserController {

    private final UserService userService;


    /*
    * User Sign Up Method
    *  - email : user's email
    *  - id : user's id
    *  - name : user's nickname
    *  - password : password
    *  - passwordCheck : to check password
    * */
    @PostMapping("signUp")
    public String userSignUp(String email, String id, String name, String password, String passwordCheck) {

        //이메일 형식 유효성 검사
        if(!isValidEmail(email)) {
            return "이메일 형식을 입력해주세요.";
        }

        // 존재하는 이메일 주소인지 확인
        if(isExistingEmail(email)) {
            return "존재하는 이메일 주소입니다. 다시 확인해 주세요";
        }

        //비밀번호, 확인 비밀번호 동일한지 체크
        if(!isCheckedPwd(password, passwordCheck)){
            return "확인 비밀번호와 불일치 합니다.";
        }

        // Create uuid
        String uid = UUID.randomUUID().toString().replaceAll("-", "");
        User user = User
                .builder()
                .uid(uid)
                .email(email)
                .id(id)
                .name(name)
                .password(password)
                .build();

        User result = userService.userSignUp(user);
        System.out.println("회원가입 결과 -> " + result);
        return "성공적으로 회원가입이 되었습니다.";
    }

    //비밀번호, 확인 비밀번호 동일한지 체크
    public boolean isCheckedPwd(String pwd1, String pwd2) {
        return pwd1.equals(pwd2);
    }

    //이메일 유효성 검사
    public static boolean isValidEmail(String email) {
        boolean isEmail = false;
        String regex = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(email);
        if(m.matches()) {
            isEmail = true;
        }
        return isEmail;
    }

    // 이미 회원가입되어 있는 이메일인지 확인
    public boolean isExistingEmail(String email) {
        return userService.isExistingEmail(email);
    };

    @PostMapping("login")
    public User userLogin(String email, String password) {
        User user = userService.login(email, password);

        if(user != null) {
            //Generate JWT Token
            String jwt_token = createToken(user);
            System.out.println(jwt_token);
        }

//        if(ObjectUtils.isEmpty(user)) { //user가 비었을 때 true
//            System.out.println("로그인실패");
//        } else {
//            System.out.println(createToken(email));
//        }
        return user;
    }

}
