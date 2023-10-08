package ru.shefer.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.shefer.model.ReportStorage;

@Controller
public class IndexController {
    private final ReportStorage reportStorage;

    public IndexController(ReportStorage reportStorage) {
        this.reportStorage = reportStorage;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("reports", reportStorage.getReportStorageList());
        return "index";
    }
}
