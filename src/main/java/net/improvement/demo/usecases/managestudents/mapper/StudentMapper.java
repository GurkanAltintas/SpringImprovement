package net.improvement.demo.usecases.managestudents.mapper;

import net.improvement.demo.usecases.managestudents.dto.StudentDTO;
import net.improvement.demo.usecases.managestudents.entity.Student;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    StudentDTO maptoDTO(Student student);

    List<StudentDTO> mapToDTO(List<Student> studentList);

    Student mapToEntity(StudentDTO studentDTO);

    List<Student> mapToEntity(List<StudentDTO> studentDTOList);
}
