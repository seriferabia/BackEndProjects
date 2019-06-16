package at.nacs.lechef.persistence.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = "id")
public class Ingredient {
  @Id
  @GeneratedValue
  private Long id;

  private String name;

  private double amount;

  private String unit;

  private boolean bought;
}
