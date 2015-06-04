package com.mongodb;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

public class HelloWorldSparkFreeMaker {
	public static void main(String[] args){
		final Configuration configuration = new Configuration();
		configuration.setClassForTemplateLoading(HelloWorldSparkFreeMaker.class, "/");
		
		Spark.get("/", new Route(){
			public Object handle(final Request request, final Response response) throws Exception {
				// TODO Auto-generated method stub
				StringWriter writer = new StringWriter();
				try {
					Template helloTemplate = configuration.getTemplate("hello.ftl");
					
					Map<String, Object> helloMap = new HashMap<String, Object>();
					
					helloMap.put("name","mandeep");
					
					try {
						helloTemplate.process(helloMap, writer);
						
					} catch (TemplateException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return writer;
			}
		});
	}
}
