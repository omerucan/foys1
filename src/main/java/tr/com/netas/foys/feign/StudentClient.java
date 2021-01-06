package tr.com.netas.foys.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tr.com.netas.foys.dto.StudentDto;

import java.util.List;

@FeignClient(value = "student", url = "http://localhost:8033")
public interface StudentClient {
    @RequestMapping(value = "/getStudents", method = RequestMethod.GET)
    List<StudentDto> getStudents();
}
