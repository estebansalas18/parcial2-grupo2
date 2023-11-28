package co.udea.ssmu.api.model.jpa.mapper.subjects;

import co.udea.ssmu.api.model.jpa.dto.subjects.SubjectDTO;
import co.udea.ssmu.api.model.jpa.mapper.EntityMapper;
import co.udea.ssmu.api.model.jpa.model.subjects.Subject;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ISubjectMapper extends EntityMapper<SubjectDTO, Subject> {
}