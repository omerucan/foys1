package tr.com.netas.foys.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tr.com.netas.foys.dto.StudentDto;
import tr.com.netas.foys.service.StudentService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/getStudents")
    public List<StudentDto> getStudents() {
        return studentService.getAll();
    }
}