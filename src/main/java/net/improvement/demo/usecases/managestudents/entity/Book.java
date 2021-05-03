package net.improvement.demo.usecases.managestudents.entity;

import lombok.Getter;
import lombok.Setter;
import net.improvement.demo.usecases.common.entity.BaseEntity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@SequenceGenerator(name="idgen", sequenceName = "BOOK_SEQ")
public class Book extends BaseEntity {


    @Column(name="Publish_Date")
    private LocalDate publishDate;

    @Column(name="Page_Count")
    private Long pageCount;






}
