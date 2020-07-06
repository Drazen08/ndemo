package io.demo;

import org.junit.Test;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/**
 * @author ：sunjx
 * @date ：Created in 2020/7/4 18:08
 * @description：
 */
public class ByteOrderTest {


    @Test
    public void byteorderTest() {
        System.out.println(ByteOrder.nativeOrder());
        ByteBuffer buf = ByteBuffer.allocate(6);
        System.out.println("Default java endian: " + buf.order().toString());
        buf.putShort((short) 1);
        buf.putShort((short) 3);
        buf.putShort((short) 2);

        for (int i = 0; i < buf.limit(); i++)
            System.out.println(buf.get() & 0xFF);

        System.out.println(Arrays.toString(buf.array()));
        System.out.println("Now: " + buf.order().toString());

        buf.flip();

        for (int i = 0; i < buf.limit(); i++)
            System.out.println(buf.get() & 0xFF);

        System.out.println(Arrays.toString(buf.array()));

        System.out.println("My PC: " + ByteOrder.nativeOrder().toString());
    }

    @Test
    public void bufferFlipTest() {
        byte[]     bytes = {10, 20, 30};
        ByteBuffer wrap  = ByteBuffer.wrap(bytes);
        wrap.position(1);
        System.out.println("ByteBuffer before flip: "
                + Arrays.toString(wrap.array())
                + "\nPosition: " + wrap.position()
                + "\nLimit: " + wrap.limit());

        // 重置buffer 游标
        wrap.flip();

        // print the byte buffer
        System.out.println("\nByteBuffer after flip: "
                + Arrays.toString(wrap.array())
                + "\nPosition: " + wrap.position()
                + "\nLimit: " + wrap.limit());
    }


}
