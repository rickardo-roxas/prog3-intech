package prelim.demo.students;

import java.io.Serializable;

public class Student implements Serializable {
    private int id;
    private String name;
    private String course;
    private int yr;
    private String gender;

    public Student(int i, String n, String c, int y, String g) {
        id = i;
        name = n;
        course = c;
        yr = y;
        gender = g;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getYr() {
        return yr;
    }

    public void setYr(int yr) {
        this.yr = yr;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
