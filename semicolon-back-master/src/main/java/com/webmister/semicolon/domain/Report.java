package com.webmister.semicolon.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.security.Timestamp;
import java.time.LocalDate;

@Entity
@Data
@Builder
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate createDate;

    @Column
    @ManyToOne
    private ReportComment reportComment;

    @Column(nullable = false)
    private String reportImageUrl = null;

    @Column
    private int likeCount;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String contents;



    @PrePersist
    public void createDate() {
        this.createDate = LocalDate.now();
    }


    @ManyToOne
    @JoinColumn(name = "userInfoId")
    @JsonBackReference
    UserInfo userInfo;

    public Report() {

    }

}
