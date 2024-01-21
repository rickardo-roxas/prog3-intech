package prelim.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SampleServer1 {
    public static void main(String[] args) {
        int port = 2000;
        try (
                ServerSocket sSocket = new ServerSocket(port);
                Socket cSocket = sSocket.accept();
                BufferedReader streamRdr = new BufferedReader(new InputStreamReader(cSocket.getInputStream()));
                PrintWriter streamWtr = new PrintWriter(cSocket.getOutputStream(), true);
                ){
            // Server sends message to client
            streamWtr.println("What is your name? ");

            // Server accepts input from client
            String name = streamRdr.readLine();
            int age;
            while (true) {
                streamWtr.println("What is your age? ");
                try {
                    age = Integer.parseInt(streamRdr.readLine());
                    if (age <= 0) {
                        throw new NumberFormatException();
                    } else {
                        break;
                    }
                } catch (NumberFormatException nfe) {
                    // println method will auto flush
                    streamWtr.println("Please enter a valid age.");
                    continue;
                }
            }
            if (age >= 18) {
                streamWtr.println(name + ", you may exercise your right to vote!");
            } else {
                streamWtr.println(name + ", you are still to young to vote!");
            }
            streamWtr.println("Thank you and good day.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
