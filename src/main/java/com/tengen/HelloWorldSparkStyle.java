package com.tengen;

import spark.Spark;

/**
 * Created by Lior on 1/10/2015.
 */
public class HelloWorldSparkStyle {
    public static void main(String[] args) {
        Spark.get("/", (request, response) -> {
            return "Hello World from Spark";
        });
    }
}
