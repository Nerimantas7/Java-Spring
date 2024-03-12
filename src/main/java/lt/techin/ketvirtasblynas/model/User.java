package lt.techin.ketvirtasblynas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity //šitos klasės objektų parametrai bus saugomi lentelėje
@Data //paleidžiame Lombok, kuris sukuria setterius ir getterius
@NoArgsConstructor //paleidžiame Lombok, kuris sukuria konstruktorių be argumentų
@AllArgsConstructor //paleidžiame Lombok, kuris sukuria konstruktorių su visais argumentais
@Table(name = "KetvirtasBlynasUsers")

public class User {

    @Id //nurodome kuris iš laukų yra unikalus (uniqId)
    @GeneratedValue(strategy = GenerationType.AUTO) //nurodome kaip generuojamas id

    private Long id;
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
}
