package tr.com.netas.foys.model;

import lombok.*;
import tr.com.netas.foys.dto.StudentDto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "STUDENT")
@EqualsAndHashCode(of = {"id"})
@Getter
@Setter
public class Student extends BaseModel {

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "CITY")
    private String city;

    @Column(name = "DISTRICT")
    private String district;

    @Column(name = "DESCRIPTION")
    private String description;

    public Student(StudentDto s) {
        this.setId(s.getId());
        this.name = s.getName();
        this.surname = s.getSurname();
        this.phoneNumber = s.getPhoneNumber();
        this.city = s.getCity();
        this.district = s.getDistrict();
        this.description = getDescription();
    }
}
