package co.udea.ssmu.api.services.students.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.udea.ssmu.api.model.jpa.dto.students.StudentDTO;
import co.udea.ssmu.api.services.students.service.StudentService;

@Service
@Transactional
public class StudentFacade {
    private final StudentService studentService;

    @Autowired
    public StudentFacade(StudentService studentService) {
        this.studentService = studentService;
    }

    public List<StudentDTO> getAllStudents() {
        return studentService.getAllStudents();
    }

    public StudentDTO getStudent(Integer id) {
        return studentService.getStudent(id);
    }
}