package com.palettering.api.palettering.user.user.service;

import com.palettering.api.palettering.user.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor

@Service
public class UserQueryService {

    private final UserRepository userRepository;

}
