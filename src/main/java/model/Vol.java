package model;

import javax.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vol {
    @Id
    private String NV;
    
    @ManyToOne
    @JoinColumn(name = "NP")
    private Pilote pilote;
    
    @ManyToOne
    @JoinColumn(name = "NA")
    private Avion avion;

    private String VD;
    private String VA;
    private int HD;
    private int HA;
}
