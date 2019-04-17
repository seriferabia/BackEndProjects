package at.nacs.drhouseadministration.view.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Invoice {

  private Long id;
  private Patient patient;
  private Kind kind;
  private String symptoms;
  private String diagnosis;
  private String provided;
  private Double cost;
  private boolean paid;
  private LocalDateTime timestamp;

}
