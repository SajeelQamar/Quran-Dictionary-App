package com.example.quranapp;

public class Model {
    public String age;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String name;

    public Model(String age, String name) {
     this.age=age;
     this.name=name;
    }


}
