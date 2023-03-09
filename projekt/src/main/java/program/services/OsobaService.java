package program.services;

import org.neo4j.driver.internal.shaded.io.netty.handler.codec.DateFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import program.repositories.OsobaRepository;

import java.sql.Date;
import java.util.List;

@Service
public class OsobaService {
    @Autowired
    OsobaRepository osobaRepository;

    public List getAll(){return osobaRepository.findAll();}
    public List getOsobaByImie(String imie){return  osobaRepository.findByImie(imie);}
    public List getOsobaByKraj(String kraj){return osobaRepository.findByKraj(kraj);}
    public List getOsobaByNazwisko(String nazwisko){return osobaRepository.findByNazwisko(nazwisko);}
    public List getOsobaByUrodziny(Date arg){return osobaRepository.findByUrodzony(arg);}
    public List getOsobaByWzrost(Long wzrost){return osobaRepository.findByWzrost(wzrost);}


}
