package program.repositories;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import program.entites.Aktor;
import program.entites.Reżyser;

import java.util.List;
@Repository
public interface ReżyserRepository extends Neo4jRepository<Reżyser,Long> {
    @Query("MATCH (re:REŻYSER) RETURN re")
    List<Reżyser> getAllReżysers();
    @Query("MATCH (re:REŻYSER)-[:WYREŻYSEROWAŁ]->(film:FILM) WHERE film.tytuł = $tyt RETURN re")
    List<Reżyser> getReżyserByFilmName(@Param("tyt") String imie);

    List filmy(String film);
}
