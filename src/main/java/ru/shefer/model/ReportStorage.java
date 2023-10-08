package ru.shefer.model;

import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class ReportStorage {
    private final List<Report> reportStorageList;

    public ReportStorage() {
        this.reportStorageList = new ArrayList<>();
        reportStorageList.add(new Report(1, 1, Date.from(Instant.now()), "Протокол испытаний Т1"));
        reportStorageList.add(new Report(2, 2, Date.from(Instant.now()), "Протокол испытаний Т2"));
        reportStorageList.add(new Report(3, 3, Date.from(Instant.now()), "Протокол испытаний Т3"));
    }

    public List<Report> getReportStorageList() {
        return reportStorageList;
    }
}
