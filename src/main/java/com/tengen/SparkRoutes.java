package com.tengen;

import spark.Route;
import spark.Spark;
/**
 * Created by Lior on 1/10/2015.
 */
//this class demonstrates how to do get requests with sparkjava.
public class SparkRoutes {
    public static void main(String[] args) {
        Spark.get("/", (request, response) -> "Hello World\n");

        Spark.get("/test", (request, response) -> "This is a test page\n");

        Spark.get("/echo/:thing", (request, response) -> request.params(":thing"));
    }
}
