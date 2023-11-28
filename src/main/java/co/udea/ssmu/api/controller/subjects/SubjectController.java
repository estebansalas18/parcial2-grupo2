package co.udea.ssmu.api.controller.subjects;

import co.udea.ssmu.api.model.jpa.dto.subjects.SubjectDTO;
import co.udea.ssmu.api.services.subjects.facade.SubjectFacade;

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
@RequestMapping("/subjects")
public class SubjectController {
    private final SubjectFacade subjectFacade;

    @Autowired
    public SubjectController(SubjectFacade subjectFacade) {
        this.subjectFacade = subjectFacade;
    }

    @GetMapping("/all")
    public List<SubjectDTO> getSubjectNames() {
        List<SubjectDTO> subjectNames = subjectFacade.getAllSubjects();
        subjectNames.sort(Comparator.comparing(SubjectDTO::getId));
        return subjectNames;
    }

    @GetMapping("/all/{id}")
    public SubjectDTO getSubject(@PathVariable Integer id) {
        return subjectFacade.getSubject(id);
    }

}