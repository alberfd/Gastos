package com.alberto.gastos.controladores;

import com.alberto.gastos.dtos.SummaryMonthDTO;
import com.alberto.gastos.servicios.SummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resumen")
public class SummaryController {

    @Autowired
    SummaryService summaryService;

    @GetMapping
    public SummaryMonthDTO getSummaryByMonth(@RequestParam("month") int month, @RequestParam("year") int year){
        return summaryService.getSummaryByMonth(month, year);
    }

}
