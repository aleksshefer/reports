package ru.shefer.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.shefer.model.Report;
import ru.shefer.model.ReportStorage;

import java.util.Optional;

@Controller
public class DeleteController {
    private final ReportStorage reportStorage;

    public DeleteController(ReportStorage reportStorage) {
        this.reportStorage = reportStorage;
    }

    @DeleteMapping("/delete")
    public String deleteReport(int reportId) {
        reportStorage
                .getReportStorageList()
                .stream()
                .filter(r -> r.getReportId() == reportId)
                .findFirst()
                .ifPresent(report -> reportStorage.getReportStorageList().remove(report));
        return "redirect:/";
    }
}
