package co.udea.ssmu.api.model.jpa.repository.subjects;

import co.udea.ssmu.api.model.jpa.model.subjects.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISubjectRepository extends JpaRepository<Subject, Integer> {
}