package com.webmister.semicolon.service;

import com.webmister.semicolon.domain.Report;
import com.webmister.semicolon.repository.ReportRepository;
import com.webmister.semicolon.request.ReportRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportService {

    @Autowired
    ReportRepository reportRepository;
    
    public Report reportRequest(Report report){
        return reportRepository.save(Report.builder()
                .title(report.getTitle())
                .contents(report.getContents())
                .likeCount(report.getLikeCount())
                .reportComment(report.getReportComment())
                .reportImageUrl(report.getReportImageUrl())
                .build());
    }

}