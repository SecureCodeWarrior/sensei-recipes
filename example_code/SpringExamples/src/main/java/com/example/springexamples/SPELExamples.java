package com.example.springexamples;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class SPELExamples {

    void SPELRaw(String query) {
        ExpressionParser ep = new SpelExpressionParser();
        ep.parseExpression(query);

        SpelExpressionParser sp = new SpelExpressionParser();
        sp.parseRaw(query);
    }
}
