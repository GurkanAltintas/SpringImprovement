package net.improvement.demo.usecases.managestudents.Service;

import lombok.RequiredArgsConstructor;
import net.improvement.demo.usecases.managestudents.dto.StudentDTO;
import net.improvement.demo.usecases.managestudents.entity.Student;
import net.improvement.demo.usecases.managestudents.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ManageStudentService {

    private final StudentRepository studentRepository;

    public List<Student> listAllStudents() {

        return studentRepository.findAll();
    }

    public Student addStudent(Student mapToEntity) {
        return studentRepository.save(mapToEntity);
    }

    public Student getByStudentNumber(String studentNumber) {
        return studentRepository.findByStudentNumber(studentNumber);
    }

    public Student update(String studentNumber, Student student) {
        Student studentFromDb=studentRepository.findByStudentNumber(studentNumber);
        student.setId(studentFromDb.getId());
        return studentRepository.save(student);

    }

    public void delete(String studentNumber) {
        studentRepository.deleteByStudentNumber(studentNumber);
    }
}
