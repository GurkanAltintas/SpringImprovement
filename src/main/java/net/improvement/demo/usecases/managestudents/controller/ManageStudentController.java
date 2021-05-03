package net.improvement.demo.usecases.managestudents.controller;

import lombok.RequiredArgsConstructor;
import net.improvement.demo.usecases.managestudents.Service.ManageStudentService;
import net.improvement.demo.usecases.managestudents.dto.StudentDTO;
import net.improvement.demo.usecases.managestudents.entity.Student;
import net.improvement.demo.usecases.managestudents.mapper.StudentMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ManageStudentController {

    private final ManageStudentService service;
    private final StudentMapper studentMapper;


    @GetMapping("/students")
    public List<StudentDTO> listAllStudents(){
        var students = service.listAllStudents();
        return studentMapper.mapToDTO(students);
    }
}
