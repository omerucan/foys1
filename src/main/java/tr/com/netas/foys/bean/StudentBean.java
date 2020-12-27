package tr.com.netas.foys.bean;

import org.primefaces.PrimeFaces;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import tr.com.netas.foys.dto.StudentDto;
import tr.com.netas.foys.enums.City;
import tr.com.netas.foys.enums.District;
import tr.com.netas.foys.service.StudentService;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.*;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named(value = "studentBean")
@ViewScoped
public class StudentBean implements Serializable {
    private List<StudentDto> students;
    private List<City> cities;
    private List<District> districts;
    private StudentDto student;

    @Autowired
    private StudentService studentService;

    @PostConstruct
    public void init() {
        student = new StudentDto();
        students = studentService.getAll();
        StudentDto s = new StudentDto();
        s.setName("Omer");
        students.add(s);
        fillCityAndDistrict();
    }

    private void fillCityAndDistrict() {
        cities = Arrays.asList(City.values());
        districts = new ArrayList<>();
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
        Map<String, Object> options = new HashMap<>();
        options.put("resizable", false);
        options.put("draggable", false);
        options.put("modal", true);
        PrimeFaces.current().dialog().openDynamic("createStudent", options, null);
    }

    public void onCarChosen(SelectEvent event) {
        StudentDto car = (StudentDto) event.getObject();
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Student Selected", "Id:" + car.getId());
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void saveStudent() {
        //todo
    }

    public void onCityChange(SelectEvent event) {
        districts.clear();
        City city = City.valueOf((String) event.getObject());
        if (city != null) {
            for (District d : District.values()) {
                if (d.getCityId() == city.getIndex()) {
                    districts.add(d);
                }
            }
        }
    }

    public StudentDto getStudent() {
        return student;
    }

    public void setStudent(StudentDto student) {
        this.student = student;
    }

    public List<City> getCities() {
        return cities;
    }

    public List<District> getDistricts() {
        return districts;
    }
}