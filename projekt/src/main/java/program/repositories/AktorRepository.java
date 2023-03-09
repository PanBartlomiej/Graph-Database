package program.repositories;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import program.entites.Aktor;
import program.entites.Film;

import java.util.List;
@Repository
public interface AktorRepository extends Neo4jRepository<Aktor,Long> {
    @Query("MATCH (aktor:AKTOR) RETURN aktor")
    List<Aktor> getAllAktors();
    @Query("MATCH (aktor:AKTOR)-[:ZAGRAŁ]->(film:FILM) WHERE film.tytuł = $tyt RETURN aktor")
    List<Aktor> getActorsByFilmName(@Param("tyt") String imie);

    List filmy(String film);
}
