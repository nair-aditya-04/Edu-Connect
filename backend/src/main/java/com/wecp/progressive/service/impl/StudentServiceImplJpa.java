package com.wecp.progressive.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wecp.progressive.dto.StudentDTO;
import com.wecp.progressive.entity.Student;
import com.wecp.progressive.exception.StudentAlreadyExistsException;
import com.wecp.progressive.repository.StudentRepository;
import com.wecp.progressive.service.StudentService;

@Service
public class StudentServiceImplJpa implements StudentService  {

    @Autowired
    StudentRepository studentRepository;
       
    public StudentServiceImplJpa(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Integer addStudent(Student student) throws Exception {
        if(studentRepository.findById(student.getStudentId()).get() != null){
            throw new StudentAlreadyExistsException("id not found");
        }
        return studentRepository.save(student).getStudentId();
    }

    @Override
    public List<Student> getAllStudentSortedByName() throws Exception {
        List<Student> ls=studentRepository.findAll();
        Collections.sort(ls);
        return ls;
    }

    public void updateStudent(Student student)throws Exception
    {
        Student sUp=studentRepository.findById(student.getStudentId()).orElse(null);
        sUp.setFullName(student.getFullName());
        sUp.setEmail(student.getEmail());
        sUp.setContactNumber(student.getContactNumber());
        sUp.setDateOfBirth(student.getDateOfBirth());
        sUp.setAddress(student.getAddress());

        studentRepository.save(sUp);
    }
    public void deleteStudent(int studentId)
    {
       // Student sDel=studentRepository.findById(studentId).orElseThrow(()-> new IllegalArgumentException("Student not found"));
        Student st=studentRepository.findByStudentId(studentId);
        studentRepository.delete(st);
    }
    public Student getStudentById(int studentId) throws Exception
    {
        return studentRepository.findById(studentId).orElse(null);
    }
    public void modifyStudentDetails(StudentDTO studentDTO){
        
    }

    @Override
    public List<Student> getAllStudents() throws Exception {
        return studentRepository.findAll();
    }
    
    

}