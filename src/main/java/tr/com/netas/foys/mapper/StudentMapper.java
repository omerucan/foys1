package tr.com.netas.foys.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import tr.com.netas.foys.dto.StudentDto;
import tr.com.netas.foys.model.Student;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    @InheritInverseConfiguration
    Student studentDto2Student(StudentDto student);

    @InheritInverseConfiguration
    List<StudentDto> listStudent2StudentDto(List<Student> students);
}