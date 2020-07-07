package io.demo;

import org.junit.Test;

/**
 * @author ：sunjx
 * @date ：Created in 2020/7/7 15:30
 * @description：
 */
public class BinaryTest {

    @Test
    public void binnaryMove3(){
        int i = 1000001100;
        int o = i>>> 5;
        System.out.println(o);
    }

}
