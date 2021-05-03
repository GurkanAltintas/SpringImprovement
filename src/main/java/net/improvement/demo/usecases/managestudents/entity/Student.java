package net.improvement.demo.usecases.managestudents.entity;

import lombok.Getter;
import lombok.Setter;
import net.improvement.demo.usecases.common.entity.BaseEntity;

import javax.persistence.*;

@Entity
@Getter
@Setter
@SequenceGenerator(name="idgen", sequenceName = "STUDENT_SEQ")
public class Student extends BaseEntity {

    @Column(name = "Name")
    private String name;

    @Column(name="Surname")
    private String surname;

    @Column(name="Email", unique = true)
    private String email;

    @Column(name="TC_KIMLIK_NO", unique = true)
    private String tcKimlikNo;

    @Column(name="Student_Number", unique = true)
    private String studentNumber;


}
