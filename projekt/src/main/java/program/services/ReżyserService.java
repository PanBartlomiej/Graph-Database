package program.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import program.entites.Aktor;
import program.entites.Film;
import program.entites.Reżyser;
import program.repositories.AktorRepository;
import program.repositories.ReżyserRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ReżyserService {
    @Autowired
    ReżyserRepository reżyserRepository;
    @Autowired
    FilmService filmService;
    public List getFilmByActorName(String name){return reżyserRepository.getReżyserByFilmName(name);}
    public List getAll(){return reżyserRepository.getAllReżysers();}
    public  List getActorsFromFilm(String film){return reżyserRepository.getReżyserByFilmName(film);}
    public Reżyser save(Reżyser aktor){
        Reżyser re1 = new Reżyser();
        re1.setImie(aktor.getImie());
        re1.setKraj(aktor.getKraj());
        re1.setWzrost(aktor.getWzrost());
        re1.setNazwisko(aktor.getNazwisko());
        re1.setUrodzony(aktor.getUrodzony());
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
        re1.setFilmy(filmy);
        System.out.println("\n\n"+re1.getFilmy()+"\n\n");
        reżyserRepository.save(re1);
        return re1;
    }
}
