package com.solvd.practice;
import java.util.*;
import java.util.stream.*;

import static com.solvd.practice.Main.logger;

public class StreamClass {
    //a simple program to demonstrate the use of stream in java
        public static void main(String args[])
        {

            // create a list of integers
            List<Integer> number = Arrays.asList(2,3,4,5);

            // demonstration of map method
            List<Integer> square = number.stream().map(x -> x*x).
                    collect(Collectors.toList());
            logger.info(square);

            // create a list of String
            List<String> names =
                    Arrays.asList("Reflection","Collection","Stream");

            // demonstration of filter method
            List<String> result = names.stream().filter(s->s.startsWith("S")).
                    collect(Collectors.toList());
            logger.info(result);

            // demonstration of sorted method
            List<String> show =
                    names.stream().sorted().collect(Collectors.toList());
            logger.info(show);

            // create a list of integers
            List<Integer> numbers = Arrays.asList(2,3,4,5,2);

            // collect method returns a set
            Set<Integer> squareSet =
                    numbers.stream().map(x->x*x).collect(Collectors.toSet());
            logger.info(squareSet);

            // demonstration of forEach method
            number.stream().map(x->x*x).forEach(y-> logger.info(y));

            // demonstration of reduce method
            int even =
                    number.stream().filter(x->x%2==0).reduce(0,(ans,i)-> ans+i);

            logger.info(even);
        }
    }


