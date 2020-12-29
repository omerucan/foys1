package tr.com.netas.foys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.netas.foys.dto.StudentDto;
import tr.com.netas.foys.model.Student;
import tr.com.netas.foys.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public void save(StudentDto studentDto) {
        Student s = new Student(studentDto);
        studentRepository.save(s);
    }

    public List<StudentDto> getAll() {
        List<StudentDto> list = new ArrayList<>();
        for (Student s : studentRepository.findAll()) {
            if (s.getDeleted() != null && !s.getDeleted()) {
                list.add(new StudentDto(s));
            }
        }
        return list;
    }
}