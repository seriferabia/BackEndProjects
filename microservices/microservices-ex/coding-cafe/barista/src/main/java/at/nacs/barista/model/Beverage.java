package at.nacs.barista.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Beverage {
  private String ticketId;
  private String name;
  private boolean isReady;
}
