package com.dockerdemo.docker.mapper;

import com.dockerdemo.docker.dto.StudentDTO;
import com.dockerdemo.docker.entity.Student;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Anish Pokhrel
 * @version 1.0.0
 * @since 1.0.0 - 2021/06/17 10:30
 */
@Component
public class StudentMapper {

    public Student mapToEntity(StudentDTO studentDTO){

        Student student = new Student();
        student.setId(studentDTO.getId());
        student.setName(studentDTO.getName());
        student.setAddress(studentDTO.getAddress());
        student.setRoll(studentDTO.getRoll());
        student.setAppointedDate(convertStringToDate(studentDTO.getAppointedDate()));
        return student;

    }

    @SneakyThrows
    private Date convertStringToDate(String appointedDate) {
        return new SimpleDateFormat("yyyy-MM-DD").parse(appointedDate);
    }

    public StudentDTO mapToDto(Student student){

        StudentDTO studentDto = new StudentDTO();
        studentDto.setId(student.getId());
        studentDto.setName(student.getName());
        studentDto.setAddress(student.getAddress());
        studentDto.setRoll(student.getRoll());
        studentDto.setAppointedDate(convertDateToString(student.getAppointedDate()));
        return studentDto;

    }

    @SneakyThrows
    private String convertDateToString(Date appointedDate) {
        return new SimpleDateFormat("yyyy-MM-DD").format(appointedDate);
    }

    public List<Student> mapToEntity(List<StudentDTO> studentDTO){
        return studentDTO
                .stream()
                .map(this::mapToEntity)
                .collect(Collectors.toList());
    }

    public List<StudentDTO> mapToDto(List<Student> students){
        return students
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }
}
