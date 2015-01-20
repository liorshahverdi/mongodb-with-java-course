package com.tengen;

import com.mongodb.BasicDBObject;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by Lior on 1/20/2015.
 */
public class DocumentRepresentationTest {
    public static void main(String[] args) {
        BasicDBObject doc = new BasicDBObject();
        doc.put("userName", "liorshahverdi");
        doc.put("birthDate", new Date(234890));
        doc.put("programmer", true);
        doc.put("age", 8); //just showing that a key's value could be one of several data types

        doc.put("languages", Arrays.asList("Java","C++"));
        doc.put("address",new BasicDBObject("street", "20 Main")
                .append("town","Great Neck")
                .append("zip","11111"));
    }

}
