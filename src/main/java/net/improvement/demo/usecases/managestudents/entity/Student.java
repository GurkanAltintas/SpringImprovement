package net.improvement.demo.usecases.managestudents.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.improvement.demo.usecases.common.entity.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@SequenceGenerator(name="idgen", sequenceName = "STUDENT_SEQ")
@ToString
public class Student extends BaseEntity {

    @Column(name = "Name")
    @Size(max = 255, message = "Name cannot be longer than 255")
    private String name;

    @Column(name="Surname")
    @Size(max = 255, message = "Surname cannot be longer than 255")
    private String surname;

    @Column(name="Email", unique = true)
    @Email
    private String email;

    @Column(name="TC_KIMLIK_NO", unique = true)
    private String tcKimlikNo;

    @Column(name="Student_Number", unique = true)
    @Size(min=7,max=7, message = "Enter truth number")
    private String studentNumber;


}
