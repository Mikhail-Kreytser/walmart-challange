package com.walmart.challenge.controller;

import com.walmart.challenge.model.Item;
import com.walmart.challenge.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class RecommendationController {

    @Autowired
    private final RecommendationService _recommendationService;

    public RecommendationController(RecommendationService recommendationService) {
        _recommendationService = recommendationService;
    }

    @GetMapping("/recommendation")
    public ResponseEntity<List<Item>> get(@RequestParam(value = "numberOfTopItems") int numberOfTopItems) {
        if (numberOfTopItems <= 0) {
            throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED,
                    String.format("Number of top items should be > 0. numberOfTopItems: %d", numberOfTopItems));
        }
        return ResponseEntity.ok(_recommendationService.get(numberOfTopItems));
    }
}
