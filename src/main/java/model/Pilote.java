package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pilote {
    @Id
    private int NP;
    private String nom;
    private String adresse;
}
