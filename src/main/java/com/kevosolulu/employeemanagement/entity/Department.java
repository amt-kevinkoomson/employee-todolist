package com.kevosolulu.employeemanagement.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Department {
    @Id
    @SequenceGenerator(
            name = "department_sequence",
            sequenceName = "department_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "department_sequence"
    )
    private Integer id;
    private String name;
    private String created_by;
    private Date created_at;
    private String code;
    @OneToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "office_id",
            referencedColumnName = "id"
    )
    private Office office;
}
