package com.webmister.semicolon.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.security.Timestamp;
import java.time.LocalDate;

@Entity
@Data
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate createDate;

    @Column
    private String comment;

    @Column
    private String reportImageUrl;

    @Column
    private int likeCount;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String contents;

    @Column
    String writingtime;

    @PrePersist
    public void createDate() {
        this.createDate = LocalDate.now();
    }

    @ManyToOne
    @JoinColumn(name = "userInfoId")
    @JsonBackReference
    UserInfo userInfo;

}
