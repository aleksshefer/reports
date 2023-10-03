package ru.shefer.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.shefer.model.ReportStorage;


@Controller
public class AllReportsController {
    private final ReportStorage reportStorage;

    public AllReportsController(ReportStorage reportStorage) {
        this.reportStorage = reportStorage;
    }

    @GetMapping("/allReports")
    public String greeting(String name, Model model) {
        model.addAttribute("reports", reportStorage.getReportStorageList());
        return "allReports";
    }
}
