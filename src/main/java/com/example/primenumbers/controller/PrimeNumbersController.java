package com.example.primenumbers.controller;

import com.example.primenumbers.service.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/")
public class PrimeNumbersController {
    final PrimeNumbersIdentifier identifier;

    public PrimeNumbersController(PrimeNumbersIdentifier identifier) {
        this.identifier = identifier;
    }

    @PostMapping("/prime")
    Map<Integer,Integer> getMapDoublesSimpleNumbers(@RequestBody List<Integer> input){
        return identifier.identifyDuplicateSimpleNumbers(input);
    }
}
