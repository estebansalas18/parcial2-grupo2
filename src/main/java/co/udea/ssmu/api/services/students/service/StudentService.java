package co.udea.ssmu.api.services.students.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.udea.ssmu.api.model.jpa.dto.students.StudentDTO;
import co.udea.ssmu.api.model.jpa.model.students.Student;
import co.udea.ssmu.api.model.jpa.repository.students.IStudentRepository;
import co.udea.ssmu.api.utils.exception.DataNotFoundException;

@Service
public class StudentService {
    private final IStudentRepository studentRepository;

    @Autowired
    public StudentService(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentDTO> getAllStudents() {
        List<Student> cities = studentRepository.findAll();
        List<StudentDTO> studentDTOs = cities.stream()
                .map(student -> new StudentDTO(student.getId(), student.getName()))
                .collect(Collectors.toList());
        return studentDTOs;
    }

    public StudentDTO getStudent(Integer id) {
        Student student = studentRepository.findById(id).orElse(null);
        if (student != null) {
            return new StudentDTO(student.getId(), student.getName());
        } else {
            throw new DataNotFoundException("El estudiante con el ID proporcionado no existe.");
        }
    }
}