package com.mongodb;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class HelloWorldFreeMarker {
	public static void main(String[] args){
		Configuration configuration = new Configuration();
		configuration.setClassForTemplateLoading(HelloWorldFreeMarker.class, "/");
		
		try {
			Template helloTemplate = configuration.getTemplate("hello.ftl");
			StringWriter writer = new StringWriter();
			Map<String, Object> helloMap = new HashMap<String, Object>();
			
			helloMap.put("name","mandeep");
			
			try {
				helloTemplate.process(helloMap, writer);
				System.out.println(writer);
			} catch (TemplateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
