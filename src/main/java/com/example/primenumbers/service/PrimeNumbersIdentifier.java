package com.example.primenumbers.service;

import org.springframework.stereotype.*;

import java.math.*;
import java.util.*;

@Service
public class PrimeNumbersIdentifier {
    private final HashSet<Integer> primeNumbers;

    public PrimeNumbersIdentifier(HashSet<Integer> simpleNumbers) {
        this.primeNumbers = simpleNumbers;
    }

    public Map<Integer, Integer> identifyDuplicateSimpleNumbers(List<Integer> input) {
        Map<Integer, Integer> result = new HashMap<>();
        input.forEach(it -> {
            if (it > 0) {
                if (primeNumbers.contains(it)) {
                    result.compute(it, (k, v) -> (v == null) ? 1 : v + 1);
                } else if (definePrimeNumber(it)) {
                    result.compute(it, (k, v) -> (v == null) ? 1 : v + 1);
                    primeNumbers.add(it);
                }
            }
        });
        return result;
    }

    private Boolean definePrimeNumber(Integer number) {
        BigInteger bigInteger = BigInteger.valueOf(number);
        return bigInteger.isProbablePrime((int) Math.log(number));
    }

}
