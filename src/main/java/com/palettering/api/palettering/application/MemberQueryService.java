package com.palettering.api.palettering.application;

import com.palettering.api.palettering.domain.member.MemberRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor

@Service
public class MemberQueryService {

    private final MemberRespository memberRepository;

}
