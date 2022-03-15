package com.webmister.semicolon.controller;


import com.webmister.semicolon.domain.UserInfo;
import com.webmister.semicolon.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/board")
public class ReportController {

    @Autowired
    ReportService reportService;



}
