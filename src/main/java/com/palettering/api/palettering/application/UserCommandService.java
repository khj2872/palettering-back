package com.palettering.api.palettering.application;

import com.palettering.api.palettering.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor

@Service
public class UserCommandService {

    private final UserRepository userRepository;

}