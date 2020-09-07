package com.demo.model;

public class User {

    @Override
    public String toString() {

        return "Id:" + this.getId() + " Name:" + this.getName() + " Age:" + this.getAge() + " Money:" + this.getMoney();
    }

    private int Id;
    private String Name;
    private int Age;
    private double Money;

    public User() {

    }

    public User(String name, int age, double money) {

        Name = name;
        Age = age;
        Money = money;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public double getMoney() {
        return Money;
    }

    public void setMoney(double money) {
        Money = money;
    }

}
