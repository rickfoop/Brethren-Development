package server;

import java.net.DatagramSocket;
import java.net.SocketException;

import config.ServerConfig;


public class DatagramServer {
    public static void main(String []args){
        try {
            new DataGramServerThread(ServerConfig.portNumber).start();
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
    
}
