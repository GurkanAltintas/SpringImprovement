package net.improvement.demo.usecases.common.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode(of="id")
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idgen")
    @Column(name="ID")
    private Long id;

    @Version
    @Column(name="Version")
    private Long version;

    @Column(name="Creation_Date")
    @CreatedDate
    private LocalDateTime creationDate;

    @Column(name="Last_Modified_Date")
    @LastModifiedDate
    private LocalDateTime lastModifiedDate;
}
