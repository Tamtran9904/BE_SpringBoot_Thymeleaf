package fa.training.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "fresher")
@Getter @Setter
public class Fresher {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;

  @Column(name = "fresher_name")
  private String name;

  @Column(name = "gender")
  private Boolean gender;

  @Column(name = "birth_date")
  private LocalDate birthDate;

  @Column(name = "has_salary")
  private Boolean hasSalary;

  @Column(name = "from_campus_link")
  private Boolean fromCampusLink;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "clazz_id", referencedColumnName = "id")
  private Clazz idClazz;
}
