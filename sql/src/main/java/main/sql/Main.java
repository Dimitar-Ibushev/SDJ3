package main.sql;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.WebSocket;
import java.net.http.WebSocket.Listener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

public class Main implements Listener {
    private static Embedded emb;
    private static ArrayList<Reading> entries;
    private final static int S1 = 1, S2 = 2, S3 = 3;
    private Reading temp = null;
    private static JSONReader read;
    private static HttpClient client;
    CompletableFuture<WebSocket> ws = client.newWebSocketBuilder()
               .buildAsync(URI.create("wss://iotnet.teracom.dk/apps?token=vnoSZwAAABFpb3RuZXQudGVyYWNvbS5kayi5FAHMm-UwpqqO3SN2YBc="), this);
    public static void main(String[] args) throws SQLException, ClassNotFoundException
    {
    	read = new JSONReader();
    	client = HttpClient.newHttpClient();

    	entries = new ArrayList<Reading>();
    	//entries.add(new Reading(S1, 10.3));
    	while(true)
    	{
    		
    		if(!(entries.isEmpty()))
    		{
    			if(!(entries.get(0) == null))
    			{
	    			Thread object = new Thread(new InsertionThread(entries.get(0).id, entries.get(0).value));
	    			object.start();
	    			entries.remove(0);
    			}
    		}
    	}

    }

   
}
