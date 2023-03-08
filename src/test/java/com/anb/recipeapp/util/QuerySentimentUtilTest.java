package com.anb.recipeapp.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuerySentimentUtilTest {

    @Test
    void keywordFinder() {
        QuerySentimentUtil querySentimentUtilTest = new QuerySentimentUtil();
        System.out.println(querySentimentUtilTest.keywordFinder("dish with milk"));
    }
}