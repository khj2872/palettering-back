package com.palettering.api.palettering.alarm.domain;

import com.palettering.api.palettering.CreatedTimeEntity;
import com.palettering.api.palettering.user.user.domain.User;
import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)

@Entity
public class Alarm extends CreatedTimeEntity {

    //알람 PK
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ALARM_ID")
    private Long id;

    //액션 취하는 주체
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "UID")
    private User user;

    //알람 타입
    @Column(nullable = false)
    private String requestType;

    //받는 회원 PK
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "TARGET_UID")
    private User targetUser;

    //알람 확인 여부(보지 않았으면 0, 봤으면 1)
    @Column(columnDefinition = "boolean default false")
    private boolean isView;

    @Builder
    public Alarm(User user, String requestType, User targetUser, boolean isView) {
        this.user = user;
        this.requestType = requestType;
        this.targetUser = targetUser;
        this.isView = isView;
    }

}
