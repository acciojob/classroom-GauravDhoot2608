package com.driver;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class StudentRepository {

    private Map<String,Student> studentMap = new HashMap<>();
    private Map<String,Teacher> teacherMap = new HashMap<>();

    private Map<String , List<String>> studentTeacherPair = new HashMap<>();

    public void addStudent(Student student){
        String name = student.getName();
        studentMap.put(name , student);
    }

    public void addTeacher(Teacher teacher){
        String name = teacher.getName();
        teacherMap.put(name , teacher);
    }

    public void addStudentTeacherPair(String studentName , String teacherName){

        List<String> students = studentTeacherPair.getOrDefault(teacherName , new ArrayList<>());
        students.add(studentName);
        studentTeacherPair.put(teacherName , students);
    }

    public Student getStudentByName(String studentName){
        return studentMap.getOrDefault(studentName , null);
    }

    public Teacher getTeacherByName(String teacherName){
        return teacherMap.getOrDefault(teacherName , null);
    }

    public List<String> getStudentByTeacherName(String teacherName){
        List<String> students = studentTeacherPair.getOrDefault(teacherName , new ArrayList<>());
        return  students;
    }

    public List<String> getAllStudents(){
        return new ArrayList<>(studentMap.keySet());
    }

    public void deleteTeacherByName(String teacherName){

        List<String> deleteStudents = studentTeacherPair.getOrDefault(teacherName , new ArrayList<>());
        for(String name : deleteStudents){
            if(studentMap.containsKey(name)){
                studentMap.remove(name);
            }
        }
        studentTeacherPair.remove(teacherName);
        teacherMap.remove(teacherName);
    }

    public void deleteAllTeachers(){
        for(String teacherName : teacherMap.keySet()){
            deleteTeacherByName(teacherName);
        }
    }

}
