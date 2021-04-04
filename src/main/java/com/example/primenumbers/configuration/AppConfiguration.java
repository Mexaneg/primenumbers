package com.example.primenumbers.configuration;

import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;

import java.util.*;

@Configuration
@ComponentScan
public class AppConfiguration {
    @Value("${divider}")
    int div;

    @Bean
    public Set<Integer> getSimpleNumbers(){
        //Implementation of Atkin's algorithm
        int limit = Integer.MAX_VALUE / div;
        ArrayList<Boolean> sieve = new ArrayList<>(limit + 1);
        int limitSqrt = (int) Math.sqrt(limit);
        for (int i = 0; i <= limit; i++) {
            sieve.add(i, false);
        }
        sieve.set(2, true);
        sieve.set(3, true);

        for (int x = 1; x <= limitSqrt; x++) {
            for (int y = 1; y <= limitSqrt; y++) {
                int n = (4 * x * x) + (y * y);
                if (n <= limit && (n % 12 == 1 || n % 12 == 5)) {
                    Boolean it = sieve.get(n);
                    sieve.set(n, !it);
                }
                n = (3 * x * x) + (y * y);
                if (n <= limit && (n % 12 == 7)) {
                    Boolean it = sieve.get(n);
                    sieve.set(n, !it);
                }
                n = (3 * x * x) - (y * y);
                if (x > y && n <= limit && (n % 12 == 11)) {
                    Boolean it = sieve.get(n);
                    sieve.set(n, !it);
                }
            }
        }
        for (int n = 5; n <= limitSqrt; n++) {
            if (sieve.get(n)) {
                int x = n * n;
                for (int i = x; i <= limit; i += x) {
                    sieve.set(i, false);
                }
            }
        }
        Set<Integer> simpleNumbers = new HashSet<>();
        for (int i =0; i< limit; i++){
            if (sieve.get(i)){
                simpleNumbers.add(i);
            }
        }
        return simpleNumbers;
    }
}
