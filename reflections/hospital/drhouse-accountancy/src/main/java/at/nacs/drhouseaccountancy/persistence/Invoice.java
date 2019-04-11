package at.nacs.drhouseaccountancy.persistence;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Invoice {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Patient patient;

    @Enumerated(EnumType.STRING)
    private Kind kind;

    private String symptoms;

    private String diagnosis;

    private String provided;

    private Double cost;

    private boolean paid;

    private LocalDateTime timestamp;
}
