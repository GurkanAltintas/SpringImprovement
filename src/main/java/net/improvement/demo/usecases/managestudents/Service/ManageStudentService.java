package net.improvement.demo.usecases.managestudents.Service;

import lombok.RequiredArgsConstructor;
import net.improvement.demo.usecases.managestudents.entity.Student;
import net.improvement.demo.usecases.managestudents.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ManageStudentService {

    private final StudentRepository studentRepository;
    public List<Student> listAllStudents(){

        return studentRepository.findAll();
    }
}
