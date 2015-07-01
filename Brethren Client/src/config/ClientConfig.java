package config;

import java.net.InetAddress;
import java.net.UnknownHostException;


public class ClientConfig {
    public static final int UDPPacketSize = 1024;
    public static final int destinationServerPort = 8080;
    public static final int numClients = 3;
    public static InetAddress getDestinationServerAddress(){
        try {
            return InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return null;
    }
}
