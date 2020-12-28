package tr.com.netas.foys.bean;

import org.primefaces.event.SelectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import tr.com.netas.foys.dto.StudentDto;
import tr.com.netas.foys.enums.City;
import tr.com.netas.foys.enums.District;
import tr.com.netas.foys.service.StudentService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.*;
import javax.inject.Named;

@Named(value = "studentBean")
@ViewScoped
public class StudentBean implements Serializable {
    private List<StudentDto> students;
    private List<City> cities;
    private List<District> districts;
    private StudentDto student;
    private boolean isViewPage = false;

    @Autowired
    private StudentService studentService;

    @PostConstruct
    public void init() {
        showDialog();
        updateData();
        fillCityAndDistrict();
    }

    private void fillCityAndDistrict() {
        cities = Arrays.asList(City.values());
        districts = new ArrayList<>();
    }

    public void updateData() {
        students = studentService.getAll();
    }

    public void editPage() {
        isViewPage = false;
    }

    public void viewPage() {
        isViewPage = true;
    }

    public void showDialog() {
        viewPage();
        student = new StudentDto();
    }

    public void saveStudent() {
        student.setDeleted(Boolean.FALSE);
        studentService.save(student);
    }

    public void deleteStudent() {
        student.setDeleted(Boolean.TRUE);
        studentService.save(student);
    }

    public void onCityChange(SelectEvent event) {
        districts.clear();
        City city = (City)event.getObject();
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

    public boolean getIsViewPage() {
        return isViewPage;
    }

    public List<StudentDto> getStudents() {
        students = studentService.getAll();
        return students;
    }
}