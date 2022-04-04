package com.webmister.semicolon.service;

import com.webmister.semicolon.domain.Report;
import com.webmister.semicolon.domain.UserInfo;
import com.webmister.semicolon.repository.ReportRepository;
import com.webmister.semicolon.repository.UserInfoRepository;
import com.webmister.semicolon.request.ReportRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReportService {

    @Autowired
    ReportRepository reportRepository;

    @Autowired
    UserInfoRepository userInfoRepository;

    public Report reportSave(Report report) {
        return reportRepository.save(Report.builder()
                .title(report.getTitle())
                .contents(report.getContents())
                .likeCount(report.getLikeCount())
                .reportComment(report.getReportComment())
                .reportImageUrl(report.getReportImageUrl())
                .build());
    }


    public Report findOneReportResponse(UserInfo userInfo, Long user_id){

        ArrayList<Report> oneReportGet = new ArrayList<Report>();

        return oneReportGet.get(Math.toIntExact(user_id));
    }



}