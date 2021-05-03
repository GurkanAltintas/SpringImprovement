package net.improvement.demo.usecases.managestudents.repository;

import net.improvement.demo.usecases.managestudents.dto.StudentDTO;
import net.improvement.demo.usecases.managestudents.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface StudentRepository extends JpaRepository<Student,Long> {

    Student findByStudentNumber(String studentNumber);
    @Transactional
    void deleteByStudentNumber(String studentNumber);

}
