package co.udea.ssmu.api.model.jpa.dto.grades;

import java.math.BigDecimal;

public class GradeDTO {
    private Integer id;
    private Integer id_student;
    private Integer id_subject;
    private BigDecimal grade;

    public GradeDTO(Integer id, Integer id_student, Integer id_subject, BigDecimal grade) {
        this.id = id;
        this.id_student = id_student;
        this.id_subject = id_subject;
        this.grade = grade;

    }

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