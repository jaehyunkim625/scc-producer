package com.example.scc.producer.application;

import com.example.scc.producer.controller.dto.CardResDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StarbucksCardQueryService {
    public List<CardResDto> findCardsByCustomerId(String customerId) {
        List<CardResDto> response = new ArrayList<>();
        response.add(new CardResDto(101L, 1000200030004000L, 500000L, customerId));
        response.add(new CardResDto(102L, 1111222233334444L, 100L, customerId));
        return response;
    }
}
