package at.nacs.lechef.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Kitchen {
  @Id
  @GeneratedValue
  private Long id;

  @OneToMany(cascade = ALL)
  @LazyCollection(LazyCollectionOption.FALSE)
  @Builder.Default
  private List<Ingredient> items = new ArrayList<>();
}
