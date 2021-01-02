package tr.com.netas.foys.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tr.com.netas.foys.enums.City;
import tr.com.netas.foys.enums.District;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentDto {
    private String id;
    private String name;
    private String surname;
    private String phoneNumber;
    private City city;
    private District district;
    private String description;
    private Boolean deleted;
}
