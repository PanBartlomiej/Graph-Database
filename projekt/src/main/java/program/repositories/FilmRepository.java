package program.repositories;

import org.springframework.data.repository.query.Param;
import program.entites.Aktor;
import program.entites.Film;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends Neo4jRepository<Film,Long> {

    List<Film> findByWydany(Long wydany);
    List<Film> findByGatunek(String gatunek);
    List<Film> findByProdukcja(String produkcja);

    @Query("MATCH (film:FILM) RETURN film")
    List<Film> getAllFilms();

    @Query(""
            +"MATCH (film:FILM) WHERE film.tytuł=$tytul1 RETURN film")
    List<Film> getFilmsByName(@Param("imie1") String tytul);

    @Query("MATCH (aktor:AKTOR)-[:ZAGRAŁ]->(film:FILM) WHERE aktor.imie=$imie1 RETURN film")
    List<Film> getActorsFromFilm(@Param("imie1") String tytulFilmu);

    @Query("MATCH (re:REŻYSER)-[:WYREŻYSEROWAŁ]->(film:FILM) WHERE re.imie=$re1 RETURN film")
    List<Film> getFilmsByReżyserName(@Param("re1") String tytulFilmu);

    

    }
