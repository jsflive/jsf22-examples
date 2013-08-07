package at.jsflive.jsf22.example01;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Michael Kurz
 */
public class Person implements Serializable {
    private final int id;
    private String name;
    private String email;
    private Date birthday;

    public Person(int id, String name, String email) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.birthday = new Date();
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
