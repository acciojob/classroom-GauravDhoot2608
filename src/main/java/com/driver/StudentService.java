package com.driver;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    StudentRepository studentRepository = new StudentRepository();

    public void addStudent(Student student){
        studentRepository.addStudent(student);
    }

    public void addTeacher(Teacher teacher){
        studentRepository.addTeacher(teacher);
    }

    public void addStudentTeacherPair(String studentName , String teacherName){
        studentRepository.addStudentTeacherPair(studentName,teacherName);
    }

    public Student getStudentByName(String studentName){
        return studentRepository.getStudentByName(studentName);
    }

    public Teacher getTeacherByName(String teacherName){
        return studentRepository.getTeacherByName(teacherName);
    }

    public List<String> getStudentByTeacherName(String teacherName){
        return studentRepository.getStudentByTeacherName(teacherName);
    }

    public List<String> getAllStudents(){
        return studentRepository.getAllStudents();
    }

    public void deleteTeacherByName(String teacherName){
        studentRepository.deleteTeacherByName(teacherName);
    }

    public void deleteAllTeachers(){
        studentRepository.deleteAllTeachers();
    }

}
