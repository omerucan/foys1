package tr.com.netas.foys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.netas.foys.dto.StudentDto;
import tr.com.netas.foys.mapper.StudentMapper;
import tr.com.netas.foys.model.Student;
import tr.com.netas.foys.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    StudentMapper studentMapper;

    public void save(StudentDto studentDto) {
        studentRepository.save(studentMapper.studentDto2Student(studentDto));
    }

    public List<StudentDto> getAll() {
        return studentMapper.listStudent2StudentDto(studentRepository.findByDeleted(Boolean.FALSE));
    }
}