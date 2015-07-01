package server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

import config.ServerConfig;


public class DataGramServerThread extends Thread{
    private int localPortNumber;
    private DatagramSocket socket;
    
    public DataGramServerThread(int localPortNumber) throws SocketException{
        this.localPortNumber=localPortNumber;
        System.out.print("Listening on local port: "+localPortNumber);
        socket = new DatagramSocket(localPortNumber);
    }
    
    public void run(){
        while(true){
            byte[] buf = new byte[ServerConfig.UDPPacketSize];
            DatagramPacket packet = new DatagramPacket(buf ,ServerConfig.UDPPacketSize);
            try {
                socket.receive(packet);
                new RequestProcessingThread(packet).start();
            } catch (IOException e){
                e.printStackTrace();
            }     
        }
    }
    
    
}
