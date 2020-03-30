package com.palettering.api.palettering.domain.user_preference;

import com.palettering.api.palettering.domain.user.User;
import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)

@Entity
public class UserPreference {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PREFERENCE_ID")
    private Long id;

    @OneToOne(mappedBy = "userPreference", fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_UID")
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
