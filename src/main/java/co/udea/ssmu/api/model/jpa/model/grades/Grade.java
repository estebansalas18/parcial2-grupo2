package co.udea.ssmu.api.model.jpa.model.grades;

import jakarta.persistence.*;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

@Entity
@Table(name = "grades")
public class Grade {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(name = "id_student")
    private Integer id_student;

    @NotNull
    @Column(name = "id_subject")
    private Integer id_subject;

    @NotNull
    @Column(name = "grade")
    private BigDecimal grade;

    public Integer getId() {
        return id;
    }

    public Integer getId_student() {
        return id_student;
    }

    public void setId_student(Integer id_student) {
        this.id_student = id_student;
    }

    public Integer getId_subject() {
        return id_subject;
    }

    public void setId_subject(Integer id_subject) {
        this.id_subject = id_subject;
    }

    public BigDecimal getGrade() {
        return grade;
    }

    public void setGrade(BigDecimal grade) {
        this.grade = grade;
    }
}