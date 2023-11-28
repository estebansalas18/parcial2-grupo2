package co.udea.ssmu.api.model.jpa.repository.students;

import co.udea.ssmu.api.model.jpa.model.students.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Integer> {

}