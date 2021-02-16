package com.springcourse.service.util;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class HashUtilTest {
    @Test
    public void getSecureTest(){
        String hash = HashUtil.getSecureHash("123");
        Assertions.assertThat(hash.length()).isEqualTo(64);
    }
}
