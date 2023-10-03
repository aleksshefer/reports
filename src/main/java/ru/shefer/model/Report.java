package ru.shefer.model;

import java.util.Date;

public class Report {
    private int reportNumber;
    private Date reportDate;
    private String reportName;

    public Report() {
    }

    public Report(int reportNumber, Date reportDate, String reportName) {
        this.reportNumber = reportNumber;
        this.reportDate = reportDate;
        this.reportName = reportName;
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
