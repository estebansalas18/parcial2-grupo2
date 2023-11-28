package co.udea.ssmu.api.services.subjects.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.udea.ssmu.api.model.jpa.dto.subjects.SubjectDTO;
import co.udea.ssmu.api.model.jpa.model.subjects.Subject;
import co.udea.ssmu.api.model.jpa.repository.subjects.ISubjectRepository;
import co.udea.ssmu.api.utils.exception.DataNotFoundException;

@Service
public class SubjectService {
    private final ISubjectRepository subjectRepository;

    @Autowired
    public SubjectService(ISubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public List<SubjectDTO> getAllSubjects() {
        List<Subject> cities = subjectRepository.findAll();
        List<SubjectDTO> subjectDTOs = cities.stream()
                .map(subject -> new SubjectDTO(subject.getId(), subject.getName()))
                .collect(Collectors.toList());
        return subjectDTOs;
    }

    public SubjectDTO getSubject(Integer id) {
        Subject subject = subjectRepository.findById(id).orElse(null);
        if (subject != null) {
            return new SubjectDTO(subject.getId(), subject.getName());
        } else {
            throw new DataNotFoundException("La materia con el ID proporcionado no existe.");
        }
    }
}