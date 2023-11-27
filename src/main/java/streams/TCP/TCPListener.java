package streams.TCP;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class TCPListener extends Thread {
  private volatile boolean running = false;
  private ServerSocket serverSocket;
  private ExecutorService executorService;
  private Properties config = new Properties();

  public TCPListener() {
    this.executorService = Executors.newFixedThreadPool(10);
  }

  public void startServer() {
    if (!running) {
      running = true;
      start();
    }
  }

  public void stopServer() {
    if (running) {
      running = false;
      try {
        serverSocket.close();
        executorService.shutdownNow();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  @Override
  public void run() {
    try {
      config.load(new FileInputStream("src/config/.env"));
      int PORT_NUMBER = Integer.parseInt(config.getProperty("PORT_NUMBER"));
      serverSocket = new ServerSocket(PORT_NUMBER);
      while (running) {
        final Socket socket = serverSocket.accept();
        if(!running) break;
        executorService.submit(new Runnable() {
          @Override
          public void run() {
            try {
              InputStream inputStream = socket.getInputStream();
              byte[] buffer = new byte[1024];
              int bytesRead = inputStream.read(buffer);
              String request = new String(buffer, 0, bytesRead);
              System.out.println("Received request from " + socket.getInetAddress() + ": " + request);
              OutputStream outputStream = socket.getOutputStream();
              String response = "Hello, client! You said: " + request + "A: " + socket.getInetAddress();
              outputStream.write(response.getBytes());
              outputStream.flush();
              socket.close();
            } catch (IOException e) {
              e.printStackTrace();
            }
          }
        });
      }
    } catch (IOException e) {
      if(!serverSocket.isClosed()){
        e.printStackTrace();
      }
    }
  }
}