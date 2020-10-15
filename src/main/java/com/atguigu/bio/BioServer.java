package com.atguigu.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author hansong
 * @ClassName BioServer
 * @create at  2020-10-15 21:26
 * @desc
 * @Version 1.0
 **/
public class BioServer {

    /***
     * @Description: 创建bio连接 监听客户端连接
     * @Param:
     * @return: void
     */
    public static void main(String[] args) throws IOException {

        // 创建线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        ServerSocket serverSocket = new ServerSocket(8066);
        System.out.println("服务器启动了");

        while (true) {
            final Socket socket = serverSocket.accept();
            System.out.println("连接到一个客户端");
            executorService.execute(new Runnable() {
                public void run() {
                    handler(socket);
                }
            });
        }
    }

    // 和客户端通讯方法
    public static void handler(Socket socket) {
        System.out.println("当前线程id:" + Thread.currentThread().getId() + ",线程名称" + Thread.currentThread().getName());
        try {
            // 获取输入流
            InputStream inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int length;
            // 循环读取客户端数
            while (true) {
                System.out.println("ready reading....");
                if ((length = inputStream.read(bytes)) != -1) {
                    // 输出
                    System.out.println("读取到数据" + new String(bytes, 0, length));
                } else {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
