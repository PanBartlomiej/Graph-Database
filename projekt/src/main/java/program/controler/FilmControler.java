package program.controler;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import program.entites.Film;
import org.springframework.beans.factory.annotation.Autowired;
import program.services.FilmService;

import java.rmi.ServerException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/filmy")
@CrossOrigin
public class FilmControler {
    @Autowired
    private FilmService filmService;

    @PostMapping(path = "/dodajFilm",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Film> create(@RequestBody Film newUser) throws Exception {

        Film film = filmService.save(newUser);
        if (film == null) {
            throw new Exception("Błąd");
        } else {
            return new ResponseEntity<>(film, HttpStatus.CREATED);
        }
    }
    @GetMapping
    public List getAllFilms(){
        return filmService.getAll();
    }

    @GetMapping("/{id}")
    public Film getFilmByID(@PathVariable String id) throws NoSuchFieldException {
        Optional film = filmService.getFilmById(Long.parseLong(id));
        if(film.isPresent()){
            return  (Film) film.get();
        }
        throw new NoSuchFieldException("Nie znaleziono filmu o tym ID");
    }
    @GetMapping("tytul/{name}")
    public List getFilmsByName(@PathVariable String name) throws NoSuchFieldException {
        List film = filmService.getFilmsByName(name);
        if(film.isEmpty())
            throw new NoSuchFieldException("Nie znaleziono filmu o tym tytule");
        else return film;
    }
    @GetMapping("gatunek/{name}")
    public List getFilmsByGatunek(@PathVariable String name) throws NoSuchFieldException {
        List film = filmService.getByGatunek(name);
        if(film.isEmpty())
            throw new NoSuchFieldException("Nie znaleziono filmu tego gatunku");
        else return film;
    }
    @GetMapping("produkcja/{name}")
    public List getFilmsByProdukcja(@PathVariable String name) throws NoSuchFieldException {
        List film = filmService.getByProdukcja(name);
        if(film.isEmpty())
            throw new NoSuchFieldException("Nie znaleziono filmu z tego roku");
        else return film;
    }

    @GetMapping("wydany/{rok}")
    public List getFilmsByWydany(@PathVariable String rok) throws NoSuchFieldException {
        List film = filmService.getByWyadny(Long.parseLong(rok));
        if(film.isEmpty())
            throw new NoSuchFieldException("Nie znaleziono filmów wydanych w tym roku w naszej bazie");
        else return film;
    }
    @GetMapping("aktorzy/{name}")
    public List getActorsFromFilm(@PathVariable String name) throws NoSuchFieldException {
        List  akotrzy = filmService.getActorsByFilmName(name);
        if(akotrzy.isEmpty())
            throw new NoSuchFieldException("Nie znalezniono takiego filmu lub żaden aktor tam nie zagrał");
        else return akotrzy;
    }
    @GetMapping("reżyserzy/{name}")
    public List getFilmsByReżyser(@PathVariable String name) throws NoSuchFieldException {
        List  filmy = filmService.getFilmsByReżyserName(name);
        if(filmy.isEmpty())
            throw new NoSuchFieldException("Nie znalezniono takiego filmu lub żaden reżyser tego nie reżyserował");
        else return filmy;
    }


    @GetMapping("/error")
    public String lol(){return "Nie znaleziono filmów wydanych w tym roku w naszej bazie";}
}
