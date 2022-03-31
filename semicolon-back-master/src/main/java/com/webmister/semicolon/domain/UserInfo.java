package com.webmister.semicolon.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    Long user_Id;

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

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;


    @OneToMany(mappedBy = "userInfo")
    @JsonManagedReference
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

