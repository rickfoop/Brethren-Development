package server;

import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;


public class RequestProcessingThread extends Thread {
    private DatagramPacket packet;
    
    public RequestProcessingThread(DatagramPacket packet){
        this.packet = packet;
    }
    
    @Override
    public void start(){
        try {
            System.out.println("I just recieved a message from: " + packet.getAddress() 
                    +":"+packet.getPort() + " and he called me a " + new String(packet.getData(), "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
