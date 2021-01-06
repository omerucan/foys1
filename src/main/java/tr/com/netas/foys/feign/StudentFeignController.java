package tr.com.netas.foys.feign;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.com.netas.foys.dto.StudentDto;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentFeignController {

    private final StudentClient studentClient;

    @GetMapping("/students")
    public List<StudentDto> getStudents() {
        return studentClient.getStudents();
    }
}
