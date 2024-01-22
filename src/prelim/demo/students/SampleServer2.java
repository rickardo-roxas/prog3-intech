package prelim.demo.students;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SampleServer2 {
    public static void main(String[] args) {
        try (
                ServerSocket clientConnection = new ServerSocket(1234);
                Socket clientSocket = clientConnection.accept();
                ObjectOutputStream writer = new ObjectOutputStream(clientSocket.getOutputStream());
                ObjectInputStream reader = new ObjectInputStream(clientSocket.getInputStream());
                ) {
            List<Student> students = (ArrayList<Student>) reader.readObject();

            Collections.<Student>sort(students, new Comparator<Student>() {
                @Override
                public int compare(Student s1, Student s2) {
                    return s1.getId() - s2.getId();
                }

                @Override
                public boolean equals(Object obj) {
                    return false;
                }
            });

            // send result of processing to client
            writer.writeObject(students);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
