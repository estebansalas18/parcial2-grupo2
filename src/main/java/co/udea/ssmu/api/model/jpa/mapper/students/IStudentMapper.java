package co.udea.ssmu.api.model.jpa.mapper.students;

import co.udea.ssmu.api.model.jpa.dto.students.StudentDTO;
import co.udea.ssmu.api.model.jpa.mapper.EntityMapper;
import co.udea.ssmu.api.model.jpa.model.students.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IStudentMapper extends EntityMapper<StudentDTO, Student> {
}