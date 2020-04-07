package com.palettering.api.palettering.report.domain;

import com.palettering.api.palettering.CreatedTimeEntity;
import com.palettering.api.palettering.user.user.domain.User;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)

@Entity
public class Report extends CreatedTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REPORT_ID")
    private Long id;

    @Column(nullable = false)
    private String requestType;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "UID")
    private User user;

    private String targetKey;

    private String reason;

    @Column(columnDefinition = "boolean default false")
    private boolean isView;

    @Column(columnDefinition = "boolean default false")
    private boolean isClosedCase;

    private LocalDateTime closedDate;

    @Builder
    public Report(String requestType, User user, String targetKey,
                  String reason, boolean isView, boolean isClosedCase,
                  LocalDateTime closedDate) {
        this.requestType = requestType;
        this.user = user;
        this.targetKey = targetKey;
        this.reason = reason;
        this.isView = isView;
        this.isClosedCase = isClosedCase;
        this.closedDate = closedDate;
    }

}
