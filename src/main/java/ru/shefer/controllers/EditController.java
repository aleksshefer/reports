package ru.shefer.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.shefer.model.Report;
import ru.shefer.model.ReportStorage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;
import java.util.UUID;

@Controller
public class EditController {
    private final ReportStorage reportStorage;

    public EditController(ReportStorage reportStorage) {
        this.reportStorage = reportStorage;
    }

    @GetMapping("/edit-form")
    public String editReportForm(int reportId, Model model) {
        Optional<Report> reportOptional = reportStorage
                .getReportStorageList()
                .stream()
                .filter(r -> r.getReportId() == reportId)
                .findFirst();
        if (reportOptional.isPresent()) {
            model.addAttribute("reportId", reportId);
            model.addAttribute("reportName", reportOptional.get().getReportName());
            model.addAttribute("reportDate", reportOptional.get().getReportDate());
            model.addAttribute("reportNumber", reportOptional.get().getReportNumber());
        }
        return "edit-form";
    }

    @PostMapping("/edit")
    public String editReport(@RequestParam int reportId, @RequestParam String reportName,
                             @RequestParam String reportDate,
                             @RequestParam int reportNumber) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

        Optional<Report> reportOptional = reportStorage
                .getReportStorageList()
                .stream()
                .filter(r -> r.getReportId() == reportId)
                .findFirst();
        if (reportOptional.isPresent()) {
            Report report = reportOptional.get();
            reportStorage.getReportStorageList().remove(report);
            report.setReportNumber(reportNumber);
            report.setReportDate(dateFormat.parse(reportDate));
            report.setReportName(reportName);
            reportStorage.getReportStorageList().add(report);
        }
        return "redirect:/";

    }
}
