package net.improvement.demo.usecases.managestudents.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class StudentDTO {
    private String name;
    private String surname;
    private String email;
    private String tcKimlikNo;
    private String studentNumber;
}
