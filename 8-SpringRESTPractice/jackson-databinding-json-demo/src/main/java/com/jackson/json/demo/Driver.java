package com.jackson.json.demo;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class Driver {
    public static void main(String[] args) {
        try{
            //create object mapper
            ObjectMapper mapper = new ObjectMapper();

            //read JSON file and map/convert to Java POJO
//            // data/sample-lite.json
//            Student student =
//                    mapper.readValue(new File("data/sample-lite.json"),Student.class);
            // data/sample-full.json
            Student student =
                    mapper.readValue(new File("data/sample-full.json"),Student.class);

            //print first and last names
            System.out.println("First name: "+student.getFirstName());
            System.out.println("Last name: "+student.getLastName());

            //print address
            Address address = student.getAddress();
            System.out.println("Street: "+address.getStreet()+"\n"+"City: "+address.getCity());

            //print languages
            for(String lang : student.getLanguages()){
                System.out.println(lang);
            }

        }catch (Exception exception){
            exception.printStackTrace();
        }
    }
}
