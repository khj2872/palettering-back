package com.palettering.api.palettering.user.user_preference.domain;

import com.palettering.api.palettering.user.user.domain.User;
import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)

@Entity
public class UserPreference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PREFERENCE_ID")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "UID")
    private User user;

    private int allFlag;

    private int dmAlarm;

    private int followingAlarm;

    private int followerAlarm;

    private int adminAlarm;

    private int tagAlarm;

    private int tagReplyAlarm;

    private int postLikeAlarm;

    private int replyLikeAlarm;

}
