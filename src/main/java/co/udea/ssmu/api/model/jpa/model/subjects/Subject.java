package co.udea.ssmu.api.model.jpa.model.subjects;

import jakarta.persistence.*;

import javax.validation.constraints.NotNull;

@Entity
@Table(name = "subjects")
public class Subject {
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