package program.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import program.entites.Aktor;
import program.entites.Film;
import program.repositories.AktorRepository;
import program.repositories.FilmRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class AktorService {
    @Autowired
    AktorRepository aktorRepository;
    @Autowired
    FilmService filmService;
    public List getFilmByActorName(String name){return aktorRepository.getActorsByFilmName(name);}
    public List getAll(){return aktorRepository.getAllAktors();}
    public  List getActorsFromFilm(String film){return aktorRepository.getActorsByFilmName(film);}
    public Aktor save(Aktor aktor){
        Aktor aktor1 = new Aktor();
        aktor1.setImie(aktor.getImie());
        aktor1.setKraj(aktor.getKraj());
        aktor1.setWzrost(aktor.getWzrost());
        aktor1.setNazwisko(aktor.getNazwisko());
        aktor1.setUrodzony(aktor.getUrodzony());
        String lista = aktor.getFilmy().toString();
        String[] lista2= lista
                .replace('[',' ')
                .replace(']',' ')
                .replaceAll(" ","")
                .split(",");
        List<String> lista3 = Arrays.asList(lista2);
        System.out.println(lista3);
        List <Film> filmy = new ArrayList<>();
        for(int i=0; i<lista3.size(); i++){
            filmy.add(filmService.getFilmById(Long.parseLong(lista3.get(i))).get());
        }
        aktor1.setFilmy(filmy);
        System.out.println("\n\n"+aktor1.getFilmy()+"\n\n");
        aktorRepository.save(aktor1);

        return aktor1;
    }
}
