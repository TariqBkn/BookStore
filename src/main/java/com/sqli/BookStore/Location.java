package com.sqli.BookStore;

public class Location {

    private  final String department;

    private  final String level;

    private  final String side;

    public Location(String department, String level, String side) {
        this.department = department;
        this.level = level;
        this.side = side;
    }

    public String getDepartment() {
        return department;
    }

    public String getLevel() {
        return level;
    }

    public String getSide() {
        return side;
    }
}
