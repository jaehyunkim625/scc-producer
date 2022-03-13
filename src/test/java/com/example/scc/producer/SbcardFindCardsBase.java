package com.example.scc.producer;

import com.example.scc.producer.application.StarbucksCardQueryService;
import com.example.scc.producer.controller.StarbucksCardController;
import com.example.scc.producer.controller.dto.CardResDto;

import io.restassured.module.mockmvc.RestAssuredMockMvc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;

//@AutoConfigureRestDocs
@ExtendWith(RestDocumentationExtension.class)
@SpringBootTest(classes = ProducerApplication.class)
public abstract class SbcardFindCardsBase {

    @Autowired
    StarbucksCardController starbucksCardController;

    @MockBean
    StarbucksCardQueryService starbucksCardQueryService;

    @BeforeEach
    public void setup(RestDocumentationContextProvider restDocumentation) {
//        RestAssuredMockMvc.standaloneSetup(starbucksCardController);
        RestAssuredMockMvc.mockMvc((MockMvcBuilders.standaloneSetup(starbucksCardController)
                .apply(documentationConfiguration(restDocumentation))
                .alwaysDo(document(getClass().getSimpleName()))
                .build()));

        // Stubbing Application Service
        List<CardResDto> stubResponse = new ArrayList<>();
        stubResponse.add(new CardResDto(1000000000L, 1111222233334444L, 5000L, "rabbit001"));
        stubResponse.add(new CardResDto(2000000000L, 5555666677778888L, 100L, "rabbit001"));

//        Mockito.when(starbucksCardQueryService.findCardsByCustomerId("rabbit001"))
//                .thenReturn(stubResponse);
        given(starbucksCardQueryService.findCardsByCustomerId(any()))
                .willReturn(stubResponse);
    }
}
