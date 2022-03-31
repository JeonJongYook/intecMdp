package com.webmister.semicolon.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Builder
public class ReportComment {

    @GeneratedValue
    @Id
    long comment_Id;

    @Column(columnDefinition = "TEXT")
    private String reply;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "report_Id")
    private Report report;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "user_Id")
    private UserInfo userInfo;

    public ReportComment() {

    }
}
