package introsde.soap.eactivity.endpoint;


import introsde.soap.eactivity.ws.*;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.xml.ws.Endpoint;


public class PeoplePublisher {

    public static String BASE_URL = "/ws/people";

    public static String getEndpointURL() throws UnknownHostException {

    	String port_value = "6901";
        if (String.valueOf(System.getenv("PORT")) != "null"){
            port_value = String.valueOf(System.getenv("PORT"));
        }
        String port = ":" + port_value;
        
        String hostname = InetAddress.getLocalHost().getHostAddress();
        if (hostname.equals("127.0.0.1"))
        {
            hostname = "localhost";
        }

        return "http://" + hostname + port + BASE_URL;        
    }

    public static void main(String[] args) throws UnknownHostException {
    	
        String endpointUrl = getEndpointURL();
        System.out.println("Starting People Service...");
        System.out.println("--> Published at = " + endpointUrl);
        Endpoint.publish(endpointUrl, new PeopleImpl());
    }
}