package com.example.primenumbers;

import com.example.primenumbers.service.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import java.util.*;

@SpringBootTest(properties = "divider=10000")
class PrimeNumbersIdentifierTests {
    @Autowired
    PrimeNumbersIdentifier identifier;

    @Test
    public void contextLoads() {
        Assertions.assertNotNull(identifier);
    }

    @Test
    void getPrimeNumbersCorrectInputData() {
        Integer[] input = {1,2,3,5,6,7,5,3,4,1,5,1,1,2,1};
        Map<Integer,Integer> result = identifier.identifyDuplicateSimpleNumbers(arrayToList(input));
        Assertions.assertEquals(5,result.size());
        Assertions.assertEquals(5, result.get(1));
        Assertions.assertEquals(1, result.get(7));
    }

    @Test
    void  getPrimeNumbersWithNegativeNumbers(){
        Integer[] input = {-1,2,3,5,6,7,5,3,4,-1,5,-1,-1,2,1};
        Map<Integer,Integer> result = identifier.identifyDuplicateSimpleNumbers(arrayToList(input));
        Assertions.assertEquals(5,result.size());
        Assertions.assertEquals(1, result.get(1));
        Assertions.assertEquals(1, result.get(7));
    }

    @Test
    void  getPrimeNumbersWithBigNumbers(){
        Integer[] input = {520019, 520021, 520031,520019,520019, 520000,995009,995009, 995000,10000000};
        Map<Integer,Integer> result = identifier.identifyDuplicateSimpleNumbers(arrayToList(input));
        Assertions.assertEquals(4,result.size());
        Assertions.assertEquals(1, result.get(520021));
        Assertions.assertEquals(3, result.get(520019));
    }

    private List<Integer> arrayToList(Integer[] array){
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list,array);
        return list;
    }
}
