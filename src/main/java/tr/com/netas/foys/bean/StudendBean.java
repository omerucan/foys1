package tr.com.netas.foys.bean;

import org.springframework.beans.factory.annotation.Autowired;
import tr.com.netas.foys.dto.StudentDto;
import tr.com.netas.foys.service.StudentService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;

@Named("studendBean")
@ViewScoped
public class StudendBean implements Serializable {
    private List<StudentDto> students;

    @Autowired
    private StudentService studentService;

    @PostConstruct
    public void init() {
        students = studentService.getAll();
    }

    public List<StudentDto> getStudents() {
        return students;
    }

    public void setService(StudentService studentService) {
        this.studentService = studentService;
    }
}