package net.improvement.demo.usecases.managestudents.repository;

import net.improvement.demo.usecases.managestudents.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {


}
