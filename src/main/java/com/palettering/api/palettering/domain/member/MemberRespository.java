package com.palettering.api.palettering.domain.member;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRespository extends JpaRepository<Member, Long> {
}