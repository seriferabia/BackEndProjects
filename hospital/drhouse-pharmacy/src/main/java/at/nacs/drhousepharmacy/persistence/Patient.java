package at.nacs.drhousepharmacy.persistence;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
    private String id;
    private String name;
    private String symptoms;
    private String diagnosis;
    private String medicine;
}
