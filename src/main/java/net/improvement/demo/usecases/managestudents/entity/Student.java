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

    @Column(name="Email")
    private String email;

    @Column(name="TC_KIMLIK_NO")
    private String tcKimlikNo;

    @Column(name="Student_Number")
    private String studentNumber;


}
