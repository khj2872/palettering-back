package com.palettering.api.palettering.follow.domain;

import com.palettering.api.palettering.BaseTimeEntity;
import com.palettering.api.palettering.user.user.domain.User;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)

@Entity
public class Follow extends BaseTimeEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FOLLOW_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "UID")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "TARGET_UID")
    private User targetUser;

    @Column(columnDefinition = "integer default 0")
    private int status;

    @Column(columnDefinition = "boolean default false")
    private boolean isBlock;

    @Column(columnDefinition = "boolean default false")
    private boolean isShow;

    @Builder
    public Follow(User user, User targetUser, int status, boolean isBlock, boolean isShow) {
        this.user = user;
        this.targetUser = targetUser;
        this.status = status;
        this.isBlock = isBlock;
        this.isShow = isShow;
    }

}
