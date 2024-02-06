package com.kevosolulu.employeemanagement.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "department")
public class Office {
    @Id
    @SequenceGenerator(
            name = "office_sequence",
            sequenceName = "office_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "office_sequence"
    )
    private Integer id;
    private String name;
    @OneToOne(
            mappedBy = "office",
            optional = false,
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "department_id",
            referencedColumnName = "office"
    )
    private Department department;
}
