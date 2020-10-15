package com.atguigu.nio;

import java.nio.IntBuffer;

/**
 * @author hansong
 * @ClassName BasicBuffer
 * @create at  2020-10-15 22:25
 * @desc
 * @Version 1.0
 **/
public class BasicBuffer {
    /***
     * @Description: 举例说明buffer的使用
     * @Param:
     * @return: void
     */
    public static void main(String[] args) {
        /**
         * 主要属性 Buffer
         * private int mark = -1; 标记
         * private int position = 0; 当然操作到哪个位置
         * private int limit; 操作的限制
         * private int capacity; buffer的容量
         *
         */
        // 创建一个buffer 类型为int 大小为5
        IntBuffer intBuffer = IntBuffer.allocate(5);
        // 循环向buffer中存放数据
        for (int i = 0; i < intBuffer.capacity(); i++) {
            intBuffer.put(i * 2);
        }

        // 从buffer中读取数据
        // 读写转换
        intBuffer.flip();
        // 可从指定position处开始操作
        intBuffer.position(1);
        // 可限制操作的个数
        intBuffer.limit(3);
        while (intBuffer.hasRemaining()) {
            System.out.println("读取到数据：" + intBuffer.get());
        }
    }
}
