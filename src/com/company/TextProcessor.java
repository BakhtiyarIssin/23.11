package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextProcessor {

    private static final String PATTERN = "[a-zA-Z]+";

    public static List<String> process(String text)
    {
        List<String> tokens = new ArrayList<>();

        Pattern pattern = Pattern.compile(PATTERN);

        Matcher matcher = pattern.matcher(text);

        while (matcher.find())
        {
            int start = matcher.start();

            int end = matcher.end();

            tokens.add(text.substring(start, end));
        }

        return tokens;
    }

    public static boolean find(List<String> tokens, String word)
    {
        boolean found = false;

        for (String string: tokens )
        {
           if(string.equalsIgnoreCase(word))
           {
               found = true;

               break;
           }
        }

        return found;
    }

}
