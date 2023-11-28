package co.udea.ssmu.api.model.jpa.mapper.grades;

import co.udea.ssmu.api.model.jpa.dto.grades.GradeDTO;
import co.udea.ssmu.api.model.jpa.mapper.EntityMapper;
import co.udea.ssmu.api.model.jpa.model.grades.Grade;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IGradeMapper extends EntityMapper<GradeDTO, Grade> {
}