package com.palettering.api.palettering.adapter;

import com.palettering.api.palettering.application.UserQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor

@RestController
@RequestMapping("/api/v1/member")
public class UserController {

    private final UserQueryService userQueryService;

    @GetMapping("")
    public String Hello() {
        return "Hello, world";
    }

}
