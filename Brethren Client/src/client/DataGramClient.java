package client;

import config.ClientConfig;


public class DataGramClient {
    public static void main(String args[]){
        for(int i=0; i<ClientConfig.numClients; i++){
            new DataGramClientThread().start();
        }
    }
}
