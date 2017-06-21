package com.baliyaan.android.library.webscraper;

import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * Created by Pulkit Singh on 10/9/2016.
 */

public class TestMain {
    public static void main(String args[])
    {
        try {
            Document document = webscraper.GetDocument("http://stackoverflow.com/questions/2971155");
            String selection = document.select(".answer").first().text();
            System.out.println(selection);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
