package com.sculpture.sand.zheng.nie.netty.io;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author: niezheng1
 * @Date: 2019/8/6 20:53
 * 传统IO编程
 */
public class IOServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);
        //接收新连接线程
        new Thread(()->{
           while (true){
               try {
                   //阻塞方法获取新的连接
                   Socket socket = serverSocket.accept();
                    new Thread(()->{
                       byte[] data = new byte[1024];
                    });
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
        });
    }

}
