package prelim.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SampleClient1 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in); // character stream
        int port = 2000;
        try (
                Socket socket = new Socket("localhost", port);
                BufferedReader streamRdr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter streamWtr = new PrintWriter(socket.getOutputStream(), true);
                ) {

            // read and print message form server
            System.out.println(streamRdr.readLine()); // reads string
            String input = keyboard.nextLine();

            // send input to the server
            streamWtr.println(input);

            // read and print message from server
            System.out.println(streamRdr.readLine());
            input = keyboard.nextLine();

            // send input to server
            streamWtr.println(input);

            // read and print server response
            System.out.println(streamRdr.readLine());

            // read and print closing message
            System.out.println(streamRdr.readLine());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
