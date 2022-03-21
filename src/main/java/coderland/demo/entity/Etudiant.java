package coderland.demo.entity;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "Etudiant")
@Table(name = "student",
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
            name = "Nom",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String Nom;
    @Column(
            name = "prenom",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String Prenom;
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

    public Etudiant() {
    }

    public Etudiant (Long id, String Nom, String Prenom, String email, Integer age)
    {
        this.id=id;
        this.Nom=Nom;
        this.Prenom=Prenom;
        this.email=email;
        this.age=age;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "id=" + id +
                ", Nom='" + Nom + '\'' +
                ", Prenom='" + Prenom + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
