package com.walmart.challenge.service.impl;

import com.walmart.challenge.model.Item;
import com.walmart.challenge.service.RecommendationService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.*;


@Service
public class RecommendationServiceImpl implements RecommendationService {

    private final EntityManager _entityManager;

    private final static String TOP_ITEMS =
            "SELECT item FROM Item item " +
                    "JOIN OrderLine orderLine ON item.id = orderLine.orderLinePK.itemId " +
                    "GROUP BY item.id " +
                    "ORDER BY SUM(orderLine.qty) DESC";

    public RecommendationServiceImpl(EntityManager entityManager) {
        _entityManager = entityManager;
    }

    @Override
    public List<Item> get(int numberOfTopItems) {
        TypedQuery<Item> query = _entityManager.createQuery(TOP_ITEMS, Item.class)
                .setMaxResults(numberOfTopItems);
        return query.getResultList();
    }
}
