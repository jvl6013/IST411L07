package edu.psu.ist411;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HTTPClient {
    public HTTPClient() {
        System.out.println("HTTP Client Started");
        try {
            InetAddress serverInetAddress = InetAddress.getLoopbackAddress();
            System.out.println(serverInetAddress);
            Socket connection;
            
            Scanner scan = new Scanner(System.in);
            while(true) {
                System.out.println("Enter a command:");
                String input = scan.nextLine();
                String methodType = input.split(" ")[0];
                if (methodType.equalsIgnoreCase("Get")) {
                    connection = new Socket(serverInetAddress, 8080);
                    try(OutputStream out = connection.getOutputStream();
                            BufferedReader in = new BufferedReader(new InputStreamReader(
                            connection.getInputStream()))) {
                        sendGet(out, input);
                        System.out.println(getResponse(in));
                    }
                } else if (methodType.equalsIgnoreCase("Post")) {
                    connection = new Socket(serverInetAddress, 8080);
                    try(OutputStream out = connection.getOutputStream();
                            BufferedReader in = new BufferedReader(new InputStreamReader(
                            connection.getInputStream()))) {
                        sendPost(out, input);
                        System.out.println(getResponse(in));
                    }
                } else if (methodType.equalsIgnoreCase("Put")) {
                    connection = new Socket(serverInetAddress, 8080);
                    try(OutputStream out = connection.getOutputStream();
                            BufferedReader in = new BufferedReader(new InputStreamReader(
                            connection.getInputStream()))) {
                        sendPut(out, input);
                        System.out.println(getResponse(in));
                    }
                } else if (methodType.equalsIgnoreCase("Delete")) {
                    connection = new Socket(serverInetAddress, 8080);
                    try(OutputStream out = connection.getOutputStream();
                            BufferedReader in = new BufferedReader(new InputStreamReader(
                            connection.getInputStream()))) {
                        sendDelete(out, input);
                        System.out.println(getResponse(in));
                    }
                } else if (methodType.equalsIgnoreCase("Exit")) {
                    System.exit(0);
                }
            }
            
        } catch (UnknownHostException ex) {
            Logger.getLogger(HTTPClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HTTPClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {
        new HTTPClient();
    }

    private String getResponse(BufferedReader in) {
        try {
            String inputLine;
            StringBuilder response = new StringBuilder();
            while((inputLine = in.readLine()) != null) {
                response.append(inputLine).append("\n");
            }
            return response.toString();
        } catch (IOException ex) {
            Logger.getLogger(HTTPClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    private void sendGet(OutputStream out, String input) {
        System.out.println("sending get");
        try {
            out.write(input.getBytes());
        } catch (IOException ex) {
            Logger.getLogger(HTTPClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void sendPost(OutputStream out, String input) {
        System.out.println("sending post");
        
        try {
            out.write(input.getBytes());
        } catch (IOException ex) {
            Logger.getLogger(HTTPClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void sendPut(OutputStream out, String input) {
        System.out.println("Sending Put");
        try {
            out.write(input.getBytes());
        } catch (IOException ex) {
            Logger.getLogger(HTTPClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void sendDelete(OutputStream out, String input) {
        System.out.println("Sending Delete");
        try {
            out.write(input.getBytes());
        } catch (IOException ex) {
            Logger.getLogger(HTTPClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
