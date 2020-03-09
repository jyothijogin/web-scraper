package com.example.scraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WebScrape {
    public static void main(String args[]) throws Exception{
        Document doc = Jsoup.connect("http://www.wikipedia.org/wiki/Switzerland").get();
        //print the title of the web page
        System.out.println("*****Printing the Title*****");
        System.out.println(doc.title());

        //extract the text marked with tag <p>
        Element body = doc.body();
        Elements paragraphs = body.getElementsByTag("p");
        System.out.println("*****Printing the Paragaraph*****");
        for (Element paragraph : paragraphs) {
            System.out.println(paragraph.text());
        }

        //extract links ( from a particular div id mw-content-text - marked with tag <p> - then with <a> )
        Element bodybyId = body.getElementById("mw-content-text");
        Elements bodybySubId = bodybyId.getElementsByTag("p");
        System.out.println("*****Printing the Links*****");
        for (Element bodybyTag : bodybySubId) {
            Elements links = bodybyTag.select("a[href]");
            System.out.println(links.attr("href"));
        }

        // extract the header h3 text
        Elements headerDiv = body.select("h3");
        System.out.println("*****Printing the Headers*****");
        for(Element header: headerDiv){
            System.out.println(header.text());
        }
    }




}
