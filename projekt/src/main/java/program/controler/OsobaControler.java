package program.controler;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import program.entites.Film;
import program.entites.Osoba;
import program.services.FilmService;
import program.services.OsobaService;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/api/osoby")
@CrossOrigin
public class OsobaControler {
    @Autowired
    OsobaService osobaService;
    @GetMapping("imie/{name}")
    public List getPersonByName(@PathVariable String name){
        List osoby = osobaService.getOsobaByImie(name);
        return osoby;
    }
    @GetMapping("urodzony/{name}")
    public List getPersonByData(@PathVariable Date name){
        List osoby = osobaService.getOsobaByUrodziny(name);
        return osoby;
    }    @GetMapping("wzors/{name}")
    public List getPersonByWzorst(@PathVariable String name){
        List osoby = osobaService.getOsobaByWzrost(Long.parseLong(name));
        return osoby;
    }    @GetMapping("nazwisko/{name}")
    public List getPersonBySurname(@PathVariable String name){
        List osoby = osobaService.getOsobaByNazwisko(name);
        return osoby;
    }
    @GetMapping("kraj/{name}")
    public List getPersonByKraj(@PathVariable String name){
        List osoby = osobaService.getOsobaByKraj(name);
        return osoby;
    }


}
