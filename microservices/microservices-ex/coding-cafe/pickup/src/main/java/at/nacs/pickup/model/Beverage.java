package at.nacs.pickup.model;

import lombok.Data;

@Data
public class Beverage {
  private String ticketId;
  private String name;
  private boolean isReady;
}
