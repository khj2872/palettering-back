package com.palettering.api.palettering.domain.report;

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
public class Report extends CreatedTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REPORT_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UID")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TARGET_UID")
    private User targetUser;

    private String reason;

    private int isView;

}
