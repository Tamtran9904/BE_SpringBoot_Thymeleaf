package fa.training.example.dto;

import fa.training.example.entity.Clazz;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class FresherDto {
  private Integer id;

  private String name;

  private Boolean gender;

  private String birthDate;

  private Boolean hasSalary;

  private Boolean fromCampusLink;

  private Clazz idClazz;
}
