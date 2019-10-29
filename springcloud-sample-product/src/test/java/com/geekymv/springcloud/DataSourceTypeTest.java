package com.geekymv.springcloud;

import com.geekymv.springcloud.enums.DataSourceType;
import org.junit.Test;

public class DataSourceTypeTest {

    @Test
    public void test() {

        System.out.println(DataSourceType.MASTER.name());

    }
}
