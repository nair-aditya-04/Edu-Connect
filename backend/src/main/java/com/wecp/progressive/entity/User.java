package com.wecp.progressive.entity;


public class User {
    private int userId;
    private String username;
    private String password;
    private String role;
    private Student student;
    private Teacher teacher;
    public User() {
    }
    public User(int userId, String username, String password, String role, Student student, Teacher teacher) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.role = role;
        this.student = student;
        this.teacher = teacher;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }
    public Teacher getTeacher() {
        return teacher;
    }
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    
}