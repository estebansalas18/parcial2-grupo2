package co.udea.ssmu.api.controller.grades;

import co.udea.ssmu.api.model.jpa.dto.grades.GradeDTO;
import co.udea.ssmu.api.services.grades.facade.GradeFacade;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/grades")
public class GradeController {
    private final GradeFacade gradeFacade;

    @Autowired
    public GradeController(GradeFacade gradeFacade) {
        this.gradeFacade = gradeFacade;
    }

    @GetMapping("/{studentId}/v1")
    public List<GradeDTO> getGradesByStudentId(@PathVariable Integer studentId) {
        List<GradeDTO> gradeNames = gradeFacade.getAllGradesByStudentId(studentId);
        gradeNames.sort(Comparator.comparing(GradeDTO::getId));
        return gradeNames;
    }

    @PostMapping("/create/v1")
    public ResponseEntity<GradeDTO> createGrade(@Valid @RequestBody GradeDTO gradeDTO) {
        GradeDTO createdGrade = gradeFacade.createGrade(gradeDTO);
        return new ResponseEntity<>(createdGrade, HttpStatus.CREATED);
    }

}