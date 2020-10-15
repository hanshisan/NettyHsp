package com.atguigu.nio;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author hansong
 * @ClassName NIOFileChannel02
 * @create at  2020-10-16 00:18
 * @desc
 * @Version 1.0
 **/
public class NIOFileChannel02 {
    /***
    * @Description: 使用nio从指定文件读取数据输出到控制台
    * @Param:
    * @return: void
    */
    public static void main(String[] args) throws IOException {
        // 创建文件输入流对象
        FileInputStream fileInputStream = new FileInputStream("/Users/hansong/Downloads/a.txt");
        // 获取输入流中channel
        FileChannel channel = fileInputStream.getChannel();
        // 根据channel大小 创建buffer
        ByteBuffer byteBuffer = ByteBuffer.allocate((int) channel.size());
        // 将channel中数据读取到buffer
        channel.read(byteBuffer);
        // 输入buffer中数据
        System.out.println(new String(byteBuffer.array()));
        fileInputStream.close();
    }
}
