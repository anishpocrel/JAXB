package com.dockerdemo.docker.controller;

import com.dockerdemo.docker.dto.StudentDTO;
import com.dockerdemo.docker.entity.Student;
import com.dockerdemo.docker.entity.Students;
import com.dockerdemo.docker.mapper.StudentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

/**
 * @author Anish Pokhrel
 * @version 1.0.0
 * @since 1.0.0 - 2021/06/17 10:25
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "student")
public class StudentController {

    private final StudentMapper studentMapper;

    @PostMapping(value = "marshall")
    public String marshall(@RequestBody StudentDTO studentdto) throws JAXBException {

        JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(studentMapper.mapToEntity(studentdto), new File("./student.xml"));

        return "Successfully Marshalled !!";
    }

    @GetMapping(value = "unmarshall")
    public String unmarshall() throws JAXBException, FileNotFoundException {

        JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Student student = (Student) unmarshaller.unmarshal(new FileReader("./student.xml"));
        System.out.println("Name ::" + student.toString());
        return "Successfully Un-marshalled !!";
    }

    @PostMapping(value = "marshallList")
    public String marshallList(@RequestBody List<StudentDTO> studentdto) throws JAXBException {

        Students students = new Students();
        students.setStudents(studentMapper.mapToEntity(studentdto));
        students.setCollegeid(12);

        JAXBContext jaxbContext = JAXBContext.newInstance(Students.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(students, new File("./studentlist.xml"));
        return "Successfully Marshalled !!";
    }

    @GetMapping(value = "unmarshallList")
    public String unmarshallList() throws JAXBException, FileNotFoundException {

        JAXBContext jaxbContext = JAXBContext.newInstance(Students.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Students students = (Students) unmarshaller.unmarshal(new FileReader("./studentlist.xml"));
        System.out.println(students.toString());
        students.getStudents()
                .forEach(student -> System.out.println(student.toString()));
        return "Successfully Un-marshalled !!";
    }
}
