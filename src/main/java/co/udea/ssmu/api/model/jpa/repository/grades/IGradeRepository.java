package co.udea.ssmu.api.model.jpa.repository.grades;

import co.udea.ssmu.api.model.jpa.model.grades.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IGradeRepository extends JpaRepository<Grade, Integer> {

    @Query("SELECT COUNT(g) > 0 FROM Grade g WHERE g.id_student = :studentId AND g.id_subject = :subjectId")
    boolean existsByIdStudentAndIdSubject(Integer studentId, Integer subjectId);

    @Query("SELECT g FROM Grade g WHERE g.id_student = :studentId")
    List<Grade> findByStudentId(Integer studentId);
}
