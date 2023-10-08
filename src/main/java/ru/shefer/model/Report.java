package ru.shefer.model;

import java.util.Date;

public class Report {
    private int reportId;
    private int reportNumber;
    private Date reportDate;
    private String reportName;

    public Report() {
    }

    public Report(int reportId, int reportNumber, Date reportDate, String reportName) {
        this.reportId = reportId;
        this.reportNumber = reportNumber;
        this.reportDate = reportDate;
        this.reportName = reportName;
    }

    public int getReportId() {
        return reportId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    public int getReportNumber() {
        return reportNumber;
    }

    public void setReportNumber(int reportNumber) {
        this.reportNumber = reportNumber;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }
}
