package tr.com.netas.foys.dto;

import lombok.*;
import tr.com.netas.foys.enums.City;
import tr.com.netas.foys.enums.District;
import tr.com.netas.foys.model.Student;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {

    @Getter
    private String id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String surname;

    @Getter
    @Setter
    private String phoneNumber;

    @Getter
    @Setter
    private City city;

    @Getter
    @Setter
    private District district;

    @Getter
    @Setter
    private String description;

    @Getter
    @Setter
    private Boolean deleted;

    public StudentDto(Student s) {
        this.id = s.getId();
        this.name = s.getName();
        this.surname = s.getSurname();
        this.phoneNumber = s.getPhoneNumber();
        this.city = City.valueOf(s.getCity());
        this.district = District.valueOf(s.getDistrict());
        this.description = s.getDescription();
        this.deleted = s.getDeleted();
    }
}
