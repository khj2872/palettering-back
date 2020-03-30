package com.palettering.api.palettering.domain.follow;

import com.palettering.api.palettering.domain.BaseTimeEntity;
import com.palettering.api.palettering.domain.user.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString

@Entity
public class Follow extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FOLLOW_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UID")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TARGET_UID")
    private User targetUser;

    private int status;

    private int isBlock;

    private int isShow;

}
