package prelim.demo.students;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SampleClient2 {
    public static void main(String[] args) {
        try (
                //
                ObjectInputStream fileRdr = new ObjectInputStream(new FileInputStream("res/students.dat"));
                Socket connection = new Socket("localhost", 1234);
                ObjectInputStream reader = new ObjectInputStream(connection.getInputStream());
                ObjectOutputStream writer = new ObjectOutputStream(connection.getOutputStream());
                ) {
            // read list in the studs.csv file
            // cast what will be read into its actual type
            List<Student> students = (ArrayList<Student>) fileRdr.readObject();

            // print and send list object to server
            System.out.println("Data before sending to server");
            printData(students);
            writer.writeObject(students);

            // retrieve processed data from server and print
            students = (ArrayList<Student>) reader.readObject();
            System.out.println("\n\nData after sending to server:");
            printData(students);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printData(List<Student> students) {
        for (Student s: students) {
            System.out.printf("%7d %-35s %-5s %1d %-6s %n",
                    s.getId(), s.getName(), s.getCourse(), s.getYr(), s.getGender());
        }
    }
}
