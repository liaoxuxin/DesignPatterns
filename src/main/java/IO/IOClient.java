package IO;

import java.io.*;
import java.net.*;
import java.util.Date;

public class IOClient {

  public static void main(String[] args) {
    // 创建多个线程，模拟多个客户端连接服务端
    for (int i = 0; i < 2; i++) {
      new Thread(() -> {
        try {
          Socket socket = new Socket("127.0.0.1", 3333);
          while (true) {
            try {
              socket.getOutputStream().write((new Date() + ": hello world " + Thread.currentThread().getName()).getBytes());
              Thread.sleep(2000);
            } catch (Exception e) {
            }
          }
        } catch (IOException e) {
        }
      }).start();
    }

  }

}

//BIO