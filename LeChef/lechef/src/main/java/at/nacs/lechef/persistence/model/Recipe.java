package at.nacs.lechef.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Recipe {
  @Id
  @GeneratedValue
  private Long id;

  @Column(unique = true)
  private String name;

  private String type;
  private String origin;

  @ElementCollection(fetch = FetchType.EAGER)
  @Builder.Default
  private List<String> labels = new ArrayList<>();

  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(cascade = CascadeType.ALL)
  @Builder.Default
  private List<Ingredient> ingredients = new ArrayList<>();
}
