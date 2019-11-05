package com.geekymv.test;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderTest {

    @Test
    public void test() {
        System.out.println(new BCryptPasswordEncoder().encode("secret123"));
    }

}
