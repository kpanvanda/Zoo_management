package org.example;

public class Visitor {
    String name;
    int age;
    long contact;
    int balance;
    String email;
    String password;

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
    private String membership;

    public long getcontact() {
        return contact;
    }

    public void setcontact(long contact) {
        this.contact = contact;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Visitor(String name, int age, long contact, int balance, String email, String password) {
        this.name = name;
        this.age = age;
        this.contact = contact;
        this.balance = balance;
        this.email = email;
        this.password = password;

    }
    public void deductBalance(int amount) {
        if (this.balance >= amount) {
            this.balance -= amount;
        }
    }


    public String getMembership() {
        return membership;
    }

    public void setMembership(String membership) {
        this.membership = membership;
    }

}