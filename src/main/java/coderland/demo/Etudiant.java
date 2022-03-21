package coderland.demo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "Etudiant")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "etudiant",
        uniqueConstraints =
                {
                        @UniqueConstraint(name = "unique_email_etudiant", columnNames ="email")
                })
public class Etudiant {
    @Id
    @SequenceGenerator(
            name = "sequence_etudiant",
            sequenceName = "sequence_etudiant",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "sequence_etudiant"

    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;
    @Column(
            name = "nom",
            nullable = false

    )
    private String nom;
    @Column(
            name = "prenom",
            nullable = false

    )
    private String prenom;
    @Column(
            name = "email",
            nullable = false
    )
    private String email;
    @Column(
            name = "age",
            nullable = false
    )
    private Integer age;

}
