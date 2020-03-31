package com.palettering.api.palettering.domain.alarm;

import com.palettering.api.palettering.domain.CreatedTimeEntity;
import com.palettering.api.palettering.domain.user.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString

@Entity
public class Alarm extends CreatedTimeEntity {

    //알람 PK
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ALARM_ID", nullable = false)
    private Long id;

    //액션 취하는 주체
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UID")
    private User user;

    //알람 타입
    private String requestType;

    //받는 회원 PK
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TARGET_UID")
    private User targetUser;

    //알람 확인 여부(보지 않았으면 0, 봤으면 1)
    private int isView;

}
