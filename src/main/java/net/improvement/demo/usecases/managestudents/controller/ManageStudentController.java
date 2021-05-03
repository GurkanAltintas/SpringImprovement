package net.improvement.demo.usecases.managestudents.controller;

import lombok.RequiredArgsConstructor;
import net.improvement.demo.usecases.managestudents.Service.ManageStudentService;
import net.improvement.demo.usecases.managestudents.dto.StudentDTO;
import net.improvement.demo.usecases.managestudents.entity.Student;
import net.improvement.demo.usecases.managestudents.mapper.StudentMapper;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ManageStudentController {

    private final ManageStudentService service;
    private final StudentMapper studentMapper;


    @GetMapping("/students")
    public List<StudentDTO> listAllStudents() {
        var students = service.listAllStudents();
        return studentMapper.mapToDTO(students);
    }

    @PostMapping("/students")
    public StudentDTO addStudent(@Valid @RequestBody StudentDTO studentDTO) {
        Student student = (studentMapper.mapToEntity(studentDTO));
        Student addedStudent = service.addStudent(student);
        return studentMapper.maptoDTO(addedStudent);
    }

    @GetMapping("/students/{studentNumber}")
    public StudentDTO getStudent(@PathVariable String studentNumber) {

        Student student = service.getByStudentNumber(studentNumber);

        return studentMapper.maptoDTO(student);
    }

    @PutMapping("/students/{studentNumber}")
    public StudentDTO update(@PathVariable String studentNumber, @Valid @RequestBody StudentDTO studentDTO) {

        Student student = service.update(studentNumber, studentMapper.mapToEntity(studentDTO));
        return studentMapper.maptoDTO(student);
    }

    @DeleteMapping("/students/{studentNumber}")
    public void delete(@PathVariable String studentNumber) {

        service.delete(studentNumber);
    }


}
