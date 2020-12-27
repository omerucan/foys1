package tr.com.netas.foys.bean;

import org.primefaces.PrimeFaces;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import tr.com.netas.foys.dto.StudentDto;
import tr.com.netas.foys.service.StudentService;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named("studentBean")
@ViewScoped
public class StudentBean implements Serializable {
    private List<StudentDto> students;

    @Autowired
    private StudentService studentService;

    @PostConstruct
    public void init() {
        students = studentService.getAll();
        StudentDto s = new StudentDto();
        s.setName("Omer");
        students.add(s);
    }

    public List<StudentDto> getStudents() {
        return students;
    }

    public void setService(StudentService studentService) {
        this.studentService = studentService;
    }

    public void onRowEdit(RowEditEvent<StudentDto> event) {
        FacesMessage msg = new FacesMessage("Student Edited", event.getObject().getId());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent<StudentDto> event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", event.getObject().getId());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void createStudent() {
        Map<String, Object> options = new HashMap<>();
        options.put("resizable", false);
        PrimeFaces.current().dialog().openDynamic("createStudent", options, null);
    }

    public void chooseCar() {
        Map<String, Object> options = new HashMap<String, Object>();
        options.put("resizable", false);
        options.put("draggable", false);
        options.put("modal", true);
        PrimeFaces.current().dialog().openDynamic("selectCar", options, null);
    }

    public void onCarChosen(SelectEvent event) {
        StudentDto car = (StudentDto) event.getObject();
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Student Selected", "Id:" + car.getId());
        FacesContext.getCurrentInstance().addMessage(null, message);
    }


}