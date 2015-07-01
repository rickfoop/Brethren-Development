package client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Random;

import config.ClientConfig;


public class DataGramClientThread extends Thread {
    @Override
    public void start(){
        try {
            while(true){
                Thread.sleep(new Random().nextInt(10)*1000);
                DatagramSocket socket = new DatagramSocket();
                byte[] buf = new byte[ClientConfig.UDPPacketSize];
                int insultChoice = new Random().nextInt(3);
                switch(insultChoice){
                    case 0:
                        buf = new byte[]{'f','u','c','k'};
                    break;
                    case 1:
                        buf = new byte[]{'b','i','t','c','h'};
                    break;
                    case 2:
                        buf = new byte[]{'b','a','s','t','a','r','d'};
                    break;               
                }
                DatagramPacket packet = new DatagramPacket(buf, buf.length, ClientConfig.getDestinationServerAddress(), ClientConfig.destinationServerPort);
                socket.send(packet);
            }
            
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
        
    }
}
