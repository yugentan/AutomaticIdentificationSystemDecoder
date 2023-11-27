package streams.UDP;

import decoder.Receiver.Receiver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Properties;

public class UDPListener extends Thread{
    public UDPListener(){};
    MulticastSocket socket;
    @Override
    public void run() {
        while (!isInterrupted()) {
            try {
                Properties config = new Properties();
                config.load(new FileInputStream("src/config/.env"));
                int PORT_NUMBER = Integer.parseInt(config.getProperty("PORT_NUMBER"));
                socket = new MulticastSocket(PORT_NUMBER);
                byte[] buffer = new byte[1024];
                String IP_ADDRESS = config.getProperty("IP_ADDRESS");
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                InetAddress group = InetAddress.getByName(IP_ADDRESS);
                socket.joinGroup(group);
                socket.receive(packet);
                InetAddress address = packet.getAddress();
                int port = packet.getPort();
                String message = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Received message from " + address + ":" + port + ": " + message);
                decodeMessage();
            } catch (InterruptedIOException e) {
                interrupt();
            } catch (IOException e) {
                break;
            }
        }
    }
    private void decodeMessage(){
        Receiver r = new Receiver();
        r.init();
    }
}
