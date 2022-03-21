package coderland.demo.repository;

import coderland.demo.Etudiant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest

class EtudiantRepositoryTest {

    @Autowired
    private EtudiantRepository etudiantRepository;

    @Test
    public void saveEtudiant() {

        Etudiant etudiant = Etudiant.builder()
                .nom("Neklou")
                .prenom("Sempes")
                .age(26)
                .email("Sepp@faspp.com")
                .build();
        etudiantRepository.save(etudiant);


    }

    @Test
    public void printAllEtudiant() {
        List<Etudiant> EtudiantList =
                etudiantRepository.findAll();

        System.out.println("EtudiantList = " + EtudiantList);
    }

    @Test
    public void printUserbyName() {
        List<Etudiant> Etudiantprint = etudiantRepository.findBynom("Neklou");
        System.out.println("Etudiantprint = " + Etudiantprint);
    }

    @Test
    public void printUserbyCaracter() {
        List<Etudiant> Etudiantprint = etudiantRepository.findBynomContaining("kl");
        System.out.println("Etudiantprint = " + Etudiantprint);
    }

    @Test
    public  void printUserbyEmail()
    {
        Etudiant Etudiantprint= etudiantRepository.getEtudiantByemail("Sepp@faspp.com");
        System.out.println("Etudiantprint = " + Etudiantprint);

    }
    @Test
    public  void printUserbyEmailNative()
    {
        Etudiant Etudiantprint= etudiantRepository.getEtudiantByemailNative("Sepp@faspp.com");
        System.out.println("Etudiantprint = " + Etudiantprint);
    }

    @Test
    public  void printUserbyEmailNativeWithparams()
    {
        Etudiant Etudiantprint= etudiantRepository.getEtudiantByemailNativeWithparams("Sepp@faspp.com");
        System.out.println("Etudiantprint = " + Etudiantprint);
    }
    @Test
    public  void updatenombyEmail()
        {
            etudiantRepository.updatenombyemail("Nekou", "Sepp@faspp.com");
            System.out.println("etudiantRepository = " + etudiantRepository);
        }
}

