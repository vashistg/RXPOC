package com.gv.archaius.test;

import java.io.IOException;

import io.github.robwin.markup.builder.MarkupLanguage;
import io.github.robwin.swagger2markup.Swagger2MarkupConverter;

public class Swagger2Markup {
	    public static void convertRemoteSwaggerToAsciiDoc() {
	        // Remote Swagger source
	        // Default is AsciiDoc
	        try {
				Swagger2MarkupConverter.from("http://localhost:8080/iLearn/api-docs.json")
				.withMarkupLanguage(MarkupLanguage.MARKDOWN).build()
				    .intoFolder("src/docs/markdown/generated");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        System.out.println("Done");
	    }

	    
	    public static void main(String[] args) {
	    	Swagger2Markup.convertRemoteSwaggerToAsciiDoc();
		}
	    
	
}
