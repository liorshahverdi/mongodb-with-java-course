package com.tengen;

import com.mongodb.*;
import freemarker.template.Configuration;
import freemarker.template.Template;
import spark.Spark;

import java.io.StringWriter;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lior on 1/10/2015.
 */
public class HelloWorldMongoDBSparkFreemarkerStyle {
    public static void main(String[] args) throws UnknownHostException{
        final Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(
                HelloWorldSparkFreemarkerStyle.class, "/");

        MongoClient client = new MongoClient(new ServerAddress("localhost", 27017));

        DB database = client.getDB("test");
        final DBCollection collection = database.getCollection("things");

        Spark.get("/", (request, response) -> {
            StringWriter writer = new StringWriter();
            try {
                Template helloTemplate = configuration.getTemplate("hello.ftl");

                DBObject document = collection.findOne();

                helloTemplate.process(document, writer);//collection.findOne() will take a DBObject, which is a subclass of Map
                System.out.println(writer);
            } catch (Exception e) {
                Spark.halt(500);
                e.printStackTrace();
            }
            return writer;
        });
    }
}
