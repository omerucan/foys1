package tr.com.netas.foys.dto;

import lombok.*;
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
    private String city;

    @Getter
    @Setter
    private String district;

    @Getter
    @Setter
    private String description;

    public StudentDto(Student s) {
        this.id = s.getId();
        this.name = s.getName();
        this.surname = s.getSurname();
        this.phoneNumber = s.getPhoneNumber();
        this.city = s.getCity();
        this.district = s.getDistrict();
        this.description = getDescription();
    }
}
