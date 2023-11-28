package co.udea.ssmu.api.controller.students;

import co.udea.ssmu.api.model.jpa.dto.students.StudentDTO;
import co.udea.ssmu.api.services.students.facade.StudentFacade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentFacade studentFacade;

    @Autowired
    public StudentController(StudentFacade studentFacade) {
        this.studentFacade = studentFacade;
    }

    @GetMapping("/names")
    public List<StudentDTO> getStudentNames() {
        List<StudentDTO> studentNames = studentFacade.getAllStudents();
        studentNames.sort(Comparator.comparing(StudentDTO::getId));
        return studentNames;
    }

    @GetMapping("/names/{id}")
    public StudentDTO getStudent(@PathVariable Integer id) {
        return studentFacade.getStudent(id);
    }

}