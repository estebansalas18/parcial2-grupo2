package co.udea.ssmu.api.services.subjects.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.udea.ssmu.api.model.jpa.dto.subjects.SubjectDTO;
import co.udea.ssmu.api.services.subjects.service.SubjectService;

@Service
@Transactional
public class SubjectFacade {
    private final SubjectService subjectService;

    @Autowired
    public SubjectFacade(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    public List<SubjectDTO> getAllSubjects() {
        return subjectService.getAllSubjects();
    }

    public SubjectDTO getSubject(Integer id) {
        return subjectService.getSubject(id);
    }
}