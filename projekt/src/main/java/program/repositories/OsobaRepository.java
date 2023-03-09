package program.repositories;

import org.springframework.data.domain.Sort;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;
import program.entites.Osoba;

import java.sql.Date;
import java.util.List;
@Repository
public interface OsobaRepository extends Neo4jRepository<Osoba,Long> {


    List<Osoba> findByImie(String imie);
    List<Osoba> findByNazwisko(String nazwisko);
    List<Osoba> findByKraj(String kraj);
    List<Osoba> findByWzrost(Long wzrost);
    List<Osoba> findByUrodzony(Date urodzony);

}
