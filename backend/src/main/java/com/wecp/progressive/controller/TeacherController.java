package com.wecp.progressive.controller;

import com.wecp.progressive.entity.Teacher;
import com.wecp.progressive.repository.TeacherRepository;
import com.wecp.progressive.service.impl.TeacherServiceImplJpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    private final TeacherRepository teacherRepository;

    @Autowired
    TeacherServiceImplJpa teacherService;

    TeacherController(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @GetMapping
    public ResponseEntity<List<Teacher>> getAllTeachers()throws Exception {
        return new ResponseEntity<>(teacherService.getAllTeachers(), HttpStatus.OK);
    }

    @GetMapping("/{teacherId}")
    public ResponseEntity<Teacher> getTeacherById(@PathVariable int teacherId) throws Exception {
        return new ResponseEntity<>(teacherService.getTeacherById(teacherId), HttpStatus.OK);
        
    }

    @PostMapping
    public ResponseEntity<Integer> addTeacher(@RequestBody Teacher teacher) throws Exception {
        return new ResponseEntity<>(teacherService.addTeacher(teacher), HttpStatus.CREATED);
    }

    @PutMapping("/{teacherId}")
    public ResponseEntity<Void> updateTeacher(@PathVariable int teacherId, @RequestBody Teacher teacher)throws Exception {
        if(teacherService.getTeacherById(teacherId)!=null)
        {
            teacherService.updateTeacher(teacher);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        
    }

    @DeleteMapping("/{teacherId}")
    public ResponseEntity<Void> deleteTeacher(@PathVariable int teacherId) throws Exception {
        if(teacherService.getTeacherById(teacherId)!=null)
        {   
            teacherService.deleteTeacher(teacherId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
    }

    @GetMapping("/yearsofexperience")
    public ResponseEntity<List<Teacher>> getTeacherSortedByYearsOfExperience() throws Exception {
        return new ResponseEntity<>(teacherService.getTeacherSortedByExperience(),HttpStatus.OK);

        // return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
