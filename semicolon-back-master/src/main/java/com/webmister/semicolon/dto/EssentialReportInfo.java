package com.webmister.semicolon.dto;

import com.webmister.semicolon.domain.Report;
import lombok.Data;

@Data
public class EssentialReportInfo {
    String title;
    String contents;
    String description;
    String writingtime;

    Report report;

    public EssentialReportInfo(Report report){
        this.title = report.getTitle();
        this.contents = report.getContents();
        this.description ="임시";
    }
}
