package com.webmister.semicolon.request;

import com.webmister.semicolon.domain.ReportComment;
import lombok.Data;

@Data
public class ReportRequest {

    private String userTitle;
    private String userContents;
    private ReportComment reportComment;
    private int userLikeCount;
    private String reportImageUrl;

}
