package co.udea.ssmu.api.services.grades.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.udea.ssmu.api.model.jpa.dto.grades.GradeDTO;
import co.udea.ssmu.api.services.grades.service.GradeService;

@Service
@Transactional
public class GradeFacade {
    private final GradeService gradeService;

    @Autowired
    public GradeFacade(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    public List<GradeDTO> getAllGradesByStudentId(Integer studentId) {
        return gradeService.getAllGradesByStudentId(studentId);
    }

    public GradeDTO createGrade(GradeDTO gradeDTO) {
        return gradeService.createGrade(gradeDTO);
    }
}