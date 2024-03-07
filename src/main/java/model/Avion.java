package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Avion {
    @Id
    private int NA;
    private String nom;
    private int capacite;
    private String localite;
}
