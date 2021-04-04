package com.example.primenumbers;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.context.*;
import org.springframework.http.*;
import org.springframework.test.web.servlet.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest(properties = "divider=10000")
public class IntegrationTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getPrimeNumbersWithNegativeNumbers() throws Exception {
        this.mockMvc.perform(post("/prime").contentType(MediaType.APPLICATION_JSON).content("[1,2,3,5,6,7,52145634,6,78945,5,3,4,1,5,1,-2,1,2,1]")).andDo(print()).andExpect(status().isOk())
            .andExpect(content().json("{\"1\":5,\"2\":2,\"3\":2,\"5\":3,\"7\":1}"));
    }

}
