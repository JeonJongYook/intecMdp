package com.webmister.semicolon.domain;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Builder
@Getter
@AllArgsConstructor
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    private String userEmail;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String userNickName;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate createDate;

    @Column(nullable = false)
    private String userUniqueID;

    @Column
    private String userProfileImageUrl;

    @Column
    private String userDescription;

    @OneToMany(mappedBy = "userInfo")
    private List<Report> reportList;

    @PrePersist
    public void createDate() {
        this.createDate = LocalDate.now();
    }


    public UserInfo setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserInfo() {

    }




}

