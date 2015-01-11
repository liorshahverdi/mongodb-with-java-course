package com.tengen;


import freemarker.template.Configuration;
import freemarker.template.Template;
import spark.Spark;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lior on 1/10/2015.
 */
public class HelloWorldSparkFreemarkerStyle {
    public static void main(String[] args) {
        final Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(
                HelloWorldSparkFreemarkerStyle.class, "/");

        Spark.get("/", (request, response) -> {
            StringWriter writer = new StringWriter();
            try {
                Template helloTemplate = configuration.getTemplate("hello.ftl");

                Map<String, Object> helloMap = new HashMap<String, Object>();
                helloMap.put("name", "Freemarker");

                helloTemplate.process(helloMap, writer);
                System.out.println(writer);
            } catch (Exception e) {
                Spark.halt(500);
                e.printStackTrace();
            }
            return writer;
        });
    }
}
