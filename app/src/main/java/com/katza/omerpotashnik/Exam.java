package com.katza.omerpotashnik;
public class Exam {
    private String name;
    private int score;
    private boolean isPassed;

    public Exam(String name, int score) {
        this.name = name;
        this.score = score;
        // נניח שציון עובר הוא 60 ומעלה
        this.isPassed = score >= 60;
    }

    public String getName() { return name; }
    public int getScore() { return score; }
    public boolean isPassed() { return isPassed; }
}