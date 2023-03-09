package program.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import program.entites.Aktor;
import program.services.AktorService;

import java.util.List;

@RestController
@RequestMapping("/api/aktorzy")
@CrossOrigin
public class AktorControler {
    @Autowired
    AktorService aktorService;

    @PostMapping(path = "/dodajAktora",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK, reason = "OK")

    public ResponseEntity<Aktor> create1(@RequestBody Aktor newUser) throws Exception {
        System.out.println(newUser);
        Aktor aktor = aktorService.save(newUser);
        if (aktor == null) {
            throw new Exception("Błąd");
        } else {
            return new ResponseEntity<>(aktor, HttpStatus.CREATED);
        }
    }
    @GetMapping("zagrał/{name}")
    public List wJakichFilamachZagral(@PathVariable String name){
        List filmy = aktorService.getFilmByActorName(name);
        return filmy;
    }
    @GetMapping()
    public List getAllActors(){
        return aktorService.getAll();
    }
    @GetMapping("filmy/{tyt}")
    public List lol(@PathVariable String tyt){
        List akorzy = aktorService.getActorsFromFilm(tyt);
        return akorzy;
    }
}
