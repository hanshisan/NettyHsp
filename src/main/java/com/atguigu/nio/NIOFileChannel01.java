package com.atguigu.nio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author hansong
 * @ClassName NioFileChannel01
 * @create at  2020-10-15 23:59
 * @desc
 * @Version 1.0
 **/
public class NIOFileChannel01 {
    /***
    * @Description: 使用nio输出文字到指定文件
    * @Param:
    * @return: void
    */
    public static void main(String[] args) throws IOException {
        String str = "hello，Netty！！！";

        // 创建文件输出流
        FileOutputStream fileOutputStream = new FileOutputStream("/Users/hansong/Downloads/a.txt");
        // 获取对应的channel  FileChannel为抽象类 实际对象为FileChannelImpl
        FileChannel channel = fileOutputStream.getChannel();
        // 创建Buffer对象
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        // 数据放入buffer中
        byteBuffer.put(str.getBytes());
        // 对buffer进行反转
        byteBuffer.flip();
        // 将buffer中数据写入channel中
        channel.write(byteBuffer);
        // 关闭资源
        fileOutputStream.close();

    }
}
