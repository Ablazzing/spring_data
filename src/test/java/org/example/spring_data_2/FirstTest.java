package org.example.spring_data_2;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class FirstTest {

    @Test
    public void contextUp() {
       log.info("Context up!");
    }

}
