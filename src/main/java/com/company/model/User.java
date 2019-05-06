package com.company.model;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class User {

    private int id;
    private String name;
    private Timestamp birthDate;

    private static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    public User() {
    }

    public User(String name, String birthInString) {
        this.name = name;

        Date date = null;
        try {
            date = formatter.parse(birthInString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.birthDate = new Timestamp(date.getTime());
    }

    public User(int id, String name, String birthInString) {
        this.id = id;
        this.name = name;

        Date date = null;
        try {
            date = formatter.parse(birthInString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.birthDate = new Timestamp(date.getTime());
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

    public Timestamp getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Timestamp birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + formatter.format(birthDate) +
                '}';
    }
}
