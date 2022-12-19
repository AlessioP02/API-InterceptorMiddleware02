package com.example.APIInterceptorMiddleware02.controllers;

import com.example.APIInterceptorMiddleware02.entities.MonthEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;


@RestController
@RequestMapping("/months")
public class MonthController {
    @Autowired
    MonthEntity monthEntity;

    @GetMapping("")
    public Month getMonths(){

        return Month.of(monthEntity.getMonthNumber());
    }
}
