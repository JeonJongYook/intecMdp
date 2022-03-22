package com.webmister.semicolon.domain;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@Builder
public class ReportComment {

    @GeneratedValue
    @Id
    long id;

    @Column(columnDefinition = "TEXT")
    private String reply;

    public ReportComment() {

    }
}
