package at.nacs.action.persistence.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalTime;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Operation {
  @Id
  @GeneratedValue
  private Long id;

  @Column(unique = true)
  private String uuid;

  private LocalTime action;
  private LocalTime reaction;

}
