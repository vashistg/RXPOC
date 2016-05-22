package com.gv.jsoup;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class XMLParser {
	public static void main(String[] args) {
		Document doc;
		try {
			doc = Jsoup.connect("http://localhost:8080/iLearn/rest.xml").get();
			Elements flights = doc.getElementsByTag("flights");  
	        for(int i=0;i<flights.size();i++){
	        	Element flight = flights.get(0);
	        }
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        	
	}
}
