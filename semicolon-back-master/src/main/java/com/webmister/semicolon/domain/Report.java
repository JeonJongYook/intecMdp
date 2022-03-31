package com.webmister.semicolon.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.security.Timestamp;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Builder
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long report_Id;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate createDate;

    @OneToMany(mappedBy = "comment_Id")
    @JoinColumn(name = "comment_Id")
    @JsonManagedReference
    private List<ReportComment> reportComment;

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
    @JoinColumn(name = "user_Id")
    @JsonBackReference
    private UserInfo userInfo;


    public Report() {

    }

}
