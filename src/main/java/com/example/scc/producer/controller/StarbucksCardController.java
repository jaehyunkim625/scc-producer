package com.example.scc.producer.controller;

import com.example.scc.producer.application.StarbucksCardQueryService;
import com.example.scc.producer.controller.dto.CardResDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class StarbucksCardController {
    private final StarbucksCardQueryService starbucksCardQueryService;

    public StarbucksCardController(StarbucksCardQueryService starbucksCardQueryService) {
        this.starbucksCardQueryService = starbucksCardQueryService;
    }

    @GetMapping("/sbcard/v1/cards/{customerId}")
    public List<CardResDto> findCards(@PathVariable("customerId") String customerId) {
        return starbucksCardQueryService.findCardsByCustomerId(customerId);
    }
}
