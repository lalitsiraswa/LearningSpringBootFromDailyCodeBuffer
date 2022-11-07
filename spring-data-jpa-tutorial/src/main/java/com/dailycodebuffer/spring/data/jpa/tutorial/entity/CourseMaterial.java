package com.dailycodebuffer.spring.data.jpa.tutorial.entity;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "course")
public class CourseMaterial {
    @Id
    @SequenceGenerator(
            name = "course_material_sequence",
            sequenceName = "course_material_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_material_sequence"
    )
    private Long courseMaterialId;
    private String url;
    // cascade enables to create and persist the course record(data) if it is not persist(store).
    // cascade enables to create and persist the child record(data) i.e course if it is not persist(store).

    // fetch = FetchType.EAGER will fetch the Data for both child(attribute) and parent(attribute)
    // fetch = FetchType.LAZY will fetch the Data only for parent(attribute)
    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
//            fetch = FetchType.EAGER

            // (optional = false) This ensures that without course you cannot save the courseMaterial
            // by-default (optional = true)
            optional = false
    )
    @JoinColumn(
            name = "course_id",
            referencedColumnName = "courseId"
    )
    private Course course;
}
