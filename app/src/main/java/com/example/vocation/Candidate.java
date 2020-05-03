package com.example.vocation;

public class Candidate {
    String name;
    String surname;
    String info;
    int votes;

    public Candidate(String name, String surname, String info, int votes) {
        this.name = name;
        this.surname = surname;
        this.info = info;
        this.votes = votes;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getInfo() {
        return info;
    }

    public int getVotes() {
        return votes;
    }
}
