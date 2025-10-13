package com.wecp.progressive.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
 
@Entity
public class User {
 
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int userId;
private String username;
private String password;
private String role;
@OneToOne
// @JoinColumn(name="teacher_id")
private Teacher teacher;
@OneToOne
// @JoinColumn(name="student_id")
private Student student;
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
public Teacher getTeacher() {
    return teacher;
}
public void setTeacher(Teacher teacher) {
    this.teacher = teacher;
}
public Student getStudent() {
    return student;
}
public void setStudent(Student student) {
    this.student = student;
}
public User(int userId, String username, String password, String role, Teacher teacher, Student student) {
    this.userId = userId;
    this.username = username;
    this.password = password;
    this.role = role;
    this.teacher = teacher;
    this.student = student;
}
public User() {
}
// public User(String username, String password, String role, Teacher teacher, Student student) {
//     this.username = username;
//     this.password = password;
//     this.role = role;
//     this.teacher = teacher;
//     this.student = student;
// }
 
 
 
 
}
 
