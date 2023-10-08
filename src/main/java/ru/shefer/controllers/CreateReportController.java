package ru.shefer.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.shefer.model.Report;
import ru.shefer.model.ReportStorage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.UUID;

@Controller
public class CreateReportController {
    private final ReportStorage reportStorage;

    public CreateReportController(ReportStorage reportStorage) {
        this.reportStorage = reportStorage;
    }

    @GetMapping("/create-form")
    public String createReportForm() {
        return "create-form";
    }

    @PostMapping("/create")
    public String createReport(@RequestParam String reportName,
                               @RequestParam String reportDate,
                               @RequestParam int reportNumber) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

        reportStorage.getReportStorageList().add(new Report(
                UUID.randomUUID().variant(),
                reportNumber,
                dateFormat.parse(reportDate),
                reportName
        ));
        return "redirect:/";
    }
}
