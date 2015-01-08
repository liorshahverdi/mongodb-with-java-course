package com.tengen;

import spark.Spark;
import spark.Spark.*;

/**
 * Created by Lior on 1/8/2015.
 */
public class HelloWorldSparkStyle {
    public static void main(String[] args) {
        Spark.get("/", (req, res) -> "Hello World From Spark");
    }
}

