package com.walmart.challenge.service;

import com.walmart.challenge.model.Item;

import java.util.List;

public interface RecommendationService {

    /**
     * @param numberOfTopItems to recommend.
     * @return a list of items that have the most qty.
     */
    List<Item> get(int numberOfTopItems);
}
