package co.udea.ssmu.api.services.grades.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.udea.ssmu.api.model.jpa.dto.grades.GradeDTO;
import co.udea.ssmu.api.model.jpa.model.grades.Grade;
import co.udea.ssmu.api.model.jpa.repository.grades.IGradeRepository;
import co.udea.ssmu.api.utils.exception.DataDuplicatedException;
import co.udea.ssmu.api.utils.exception.DataNotFoundException;

@Service
public class GradeService {
    private final IGradeRepository gradeRepository;

    @Autowired
    public GradeService(IGradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    public List<GradeDTO> getAllGradesByStudentId(Integer studentId) {
        List<Grade> grades = gradeRepository.findByStudentId(studentId);

        if (grades.isEmpty()) {
            throw new DataNotFoundException("No se encontraron notas para el estudiante con ID: " + studentId);
        }

        return grades.stream()
                .map(grade -> new GradeDTO(grade.getId(), grade.getId_student(), grade.getId_subject(),
                        grade.getGrade()))
                .collect(Collectors.toList());
    }

    public GradeDTO createGrade(GradeDTO gradeDTO) {
        Integer idStudent = gradeDTO.getId_student();
        Integer idSubject = gradeDTO.getId_subject();

        if (gradeRepository.existsByIdStudentAndIdSubject(idStudent, idSubject)) {
            throw new DataDuplicatedException("Ya existe un registro para el estudiante con ID " + idStudent +
                    " y el ID del sujeto " + idSubject);
        }

        // Crear una nueva entidad Grade a partir del DTO
        Grade newGrade = new Grade();
        newGrade.setId_student(idStudent);
        newGrade.setId_subject(idSubject);
        newGrade.setGrade(gradeDTO.getGrade());

        // Guardar la nueva entidad en la base de datos
        Grade savedGrade = gradeRepository.save(newGrade);

        // Devolver el DTO de la entidad recién creada
        return new GradeDTO(savedGrade.getId(), savedGrade.getId_student(), savedGrade.getId_subject(),
                savedGrade.getGrade());
    }

}