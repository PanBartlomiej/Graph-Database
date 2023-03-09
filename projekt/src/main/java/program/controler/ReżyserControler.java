package program.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import program.entites.Aktor;
import program.entites.Reżyser;
import program.services.AktorService;
import program.services.ReżyserService;

import java.util.List;

@RestController
@RequestMapping("/api/reżyserzy")
@CrossOrigin
public class ReżyserControler {
    @Autowired
    ReżyserService reżyserService;

    @PostMapping(path = "/dodajReżysera",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK, reason = "OK")
    public ResponseEntity<Reżyser> create(@RequestBody Reżyser newUser) throws Exception {

        Reżyser reżyser = reżyserService.save(newUser);
        if (reżyser == null) {
            throw new Exception("Błąd");
        } else {
            return new ResponseEntity<>(reżyser, HttpStatus.CREATED);
        }
    }
    @GetMapping("wyreżyserował/{name}")
    public List wJakichFilamachZagral(@PathVariable String name){
        List filmy = reżyserService.getActorsFromFilm(name);
        return filmy;
    }
    @GetMapping()
    public List getAllActors(){
        return reżyserService.getAll();
    }
    @GetMapping("filmy/{tyt}")
    public List lol(@PathVariable String tyt){
        List akorzy = reżyserService.getActorsFromFilm(tyt);
        return akorzy;
    }
}
