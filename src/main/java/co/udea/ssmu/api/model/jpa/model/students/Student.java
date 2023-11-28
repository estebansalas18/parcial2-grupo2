package co.udea.ssmu.api.model.jpa.model.students;

import jakarta.persistence.*;

import javax.validation.constraints.NotNull;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Column(name = "name")
    private String name;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}