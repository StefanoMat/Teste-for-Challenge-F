package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {

	    // write your code

        int count = new Main().countContries();

        System.out.println(count);


    }

    public int countContries() throws IOException {

        String linkForRead = "C:\\Users\\estaf\\IdeaProjects\\readCsv\\src\\resources\\data.csv";
        BufferedReader buffer;
        String line = "";
        System.out.println(linkForRead);
        String[] country;
        List<String> clubs = new ArrayList();
        int numberOfCountries = 0;
        int numberOfNames = 0;

        buffer = new BufferedReader(new FileReader(linkForRead));
        while ((line = buffer.readLine()) != null) {

            country = line.split(",");
            // System.out.println(country[3]);
            if(clubs.contains(country[14])){
                

            }else{
                clubs.add(country[14]);
            }



        }

        System.out.println(clubs);
        return numberOfCountries;

    }
}
