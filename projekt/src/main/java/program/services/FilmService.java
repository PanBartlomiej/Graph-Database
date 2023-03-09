package program.services;

import org.springframework.context.annotation.ComponentScan;
import program.entites.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import program.repositories.FilmRepository;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class FilmService {
    @Autowired
    FilmRepository filmRepository;

    public Film save(Film f){
        var film = new Film();
        film.setGatunek(f.getGatunek());
        film.setProdukcja(f.getProdukcja());
        film.setTytuł(f.getTytuł());
        film.setWydany(f.getWydany());
        filmRepository.save(film);
        return  film;
    }
    public List getAll(){
        return filmRepository.getAllFilms();
    }
    public List getFilmsByName(String name){
        return filmRepository.getFilmsByName(name);
    }
    public List getByWyadny(Long wydany){
        return filmRepository.findByWydany(wydany);
    }
    public List getByGatunek(String gatunek){
        return filmRepository.findByGatunek(gatunek);
    }
    public List getByProdukcja(String  produkcja){
        return filmRepository.findByProdukcja(produkcja);
    }
    public Film saveFilm(Film film){
        return filmRepository.save(film);
    }
    public Optional<Film> getFilmById(Long id){
        return filmRepository.findById(id);
    }
    public Optional<Film> getFilmByName(String name){
        Film film = new Film();
        film.setTytuł(name);

        return filmRepository.findOne(Example.of(film));
    }
    public List getActorsByFilmName(String filmName){return filmRepository.getActorsFromFilm(filmName);}
    public List getFilmsByReżyserName(String reName){return  filmRepository.getFilmsByReżyserName(reName);}
}
