package coderland.demo.repository;
import coderland.demo.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {


    List<Etudiant> findBynom(String nom);

    List<Etudiant> findBynomContaining(String nom);

    List<Etudiant> findByprenomNotNull();

    //JPQL
    @Query("select e from Etudiant e where e.email = ?1")
    Etudiant getEtudiantByemail(String email);

    //Requete SQL native

    @Query(
            value = "SELECT  * from etudiant e where e.email = ?1",
            nativeQuery = true
    )
    Etudiant getEtudiantByemailNative(String email);

    //Requete SQL native avec paramettre
    @Query(
            value = "SELECT  * from etudiant e where e.email = :email",
            nativeQuery = true
    )
    Etudiant getEtudiantByemailNativeWithparams(
            @Param("email")
                    String email
    );

    //
    @Modifying
    @Transactional
    @Query(
            value = "update etudiant set nom= ?1 where email= ?2",
            nativeQuery = true
    )
    int  updatenombyemail(String nom , String email);

}
