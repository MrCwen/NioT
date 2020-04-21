package com.alibaba.test;

import java.nio.ByteBuffer;

/**
 * @author Mr.cai
 * @date 2020/4/1 - 17:59
 */
public class NioMain {
    public static void main(String[] args) {
        String str = "abc";
        //分配缓冲区大小
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());


        byteBuffer.put(str.getBytes());

        System.out.println("==========存储数据后缓冲区position位置");
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());


        //切换到读取数据的模式，这时limit会变为缓冲区实际大小的位置
        byteBuffer.flip();
        System.out.println("==========读取缓冲区的数据");
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());

        byte[] dest = new byte[byteBuffer.limit()];
        byteBuffer.get(dest);
        System.out.println(new String(dest,0,dest.length));


        //rewind:可重复读数据
        byteBuffer.rewind();
        System.out.println("==========rewind()");
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());

        //5.清空缓冲区,会回到最初状态，里面数据还在，只是清楚了position和limit的位置
        byteBuffer.clear();
        System.out.println("==========rewind()");
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());
    }

}
