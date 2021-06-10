package School.Management.Entities;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "student")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private int age;
    private String birthPlace;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date birthDate;
    private int studentclass;
    private String schoolorigin;
    private int studentstatus;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public int getStudentclass() {
        return studentclass;
    }

    public void setStudentclass(int studentclass) {
        this.studentclass = studentclass;
    }

    public String getSchoolorigin() {
        return schoolorigin;
    }

    public void setSchoolorigin(String schoolorigin) {
        this.schoolorigin = schoolorigin;
    }

    public int getStudentstatus() {
        return studentstatus;
    }

    public void setStudentstatus(int studentstatus) {
        this.studentstatus = studentstatus;
    }

    @Override
    public String toString() {
        return "StudentEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", birthPlace='" + birthPlace + '\'' +
                ", birthDate=" + birthDate +
                ", studentclass=" + studentclass +
                ", schoolorigin='" + schoolorigin + '\'' +
                ", studentstatus=" + studentstatus +
                '}';
    }
}
