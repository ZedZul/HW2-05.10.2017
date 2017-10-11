package com.zedzul.github.hw2_05102017;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Calculator implements ICalculator {

    @Override
    public String solve(final String value) {
        //TODO: It works but can be better
        String result="";
        try {
            final Pattern p = Pattern.compile("[0-9]+");
            final Matcher numbers = p.matcher(value);
            final Pattern p2 = Pattern.compile("\\+|-|\\*|/");
            final Matcher operation = p2.matcher(value);

            numbers.find();
            final long a = Long.valueOf(value.substring(numbers.start(), numbers.end()));
            numbers.find();
            final long b = Long.valueOf(value.substring(numbers.start(), numbers.end()));

            operation.find();
            final String k = value.substring(operation.start(), operation.end());
            switch (k) {
                case "+":
                    result = String.valueOf(a + b);
                    break;
                case "-":
                    result = String.valueOf(a - b);
                    break;
                case "*":
                    result = String.valueOf(a * b);
                    break;
                case "/":
                    result = String.valueOf(a / b);
                    break;
                default:
                    break;
            }
        }catch (Exception e){
            result = e.getMessage();
        }
        return result;
    }

}
