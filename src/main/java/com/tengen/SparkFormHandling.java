package com.tengen;

import freemarker.template.Configuration;
import freemarker.template.Template;
import spark.Route;
import spark.Spark;

import java.io.StringWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lior on 1/10/2015.
 */
public class SparkFormHandling {
    public static void main(String[] args) {
        final Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(
                SparkFormHandling.class, "/");

        Spark.get("/", (request, response) -> {
           try{
               Map<String, Object> fruitsMap = new HashMap<String, Object>();
               fruitsMap.put("fruits",
                       Arrays.asList("apple", "orange", "banana", "peach"));

               Template fruitPickerTemplate = configuration.getTemplate("fruitPicker.ftl");
               StringWriter writer = new StringWriter();
               fruitPickerTemplate.process(fruitsMap, writer);
               return writer;

           }catch(Exception e) {
               Spark.halt(500);
               return null;
           }
        });

        Spark.post("/favorite_fruit", (request, response) -> {
            final String fruit = request.queryParams("fruit");
            if (fruit == null) {
                return "why don't you pick one?";
            }else{
                return "Your fruit is "+fruit;
            }
        });
    }
}
