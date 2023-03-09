package program.entites;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.time.LocalDate;
import java.util.List;

@Node("REŻYSER")
public class Reżyser {
    @Id
    @GeneratedValue
    private Long id;
    private String imie;
    private String nazwisko;
    private String kraj;
    private Long wzrost;
    private LocalDate urodzony;
    @Relationship(type = "WYREŻYSEROWAŁ",direction = Relationship.Direction.OUTGOING)
    private List filmy;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getImie() {        return imie;    }
    public void setImie(String imie) {        this.imie = imie;    }
    public String getNazwisko() {        return nazwisko;    }
    public void setNazwisko(String nazwisko) {        this.nazwisko = nazwisko;    }
    public String getKraj() {        return kraj;    }
    public void setKraj(String kraj) {        this.kraj = kraj;    }
    public Long getWzrost() {        return wzrost;    }
    public void setWzrost(Long wzrost) {        this.wzrost = wzrost;    }
    public LocalDate getUrodzony() {        return urodzony;    }
    public void setUrodzony(LocalDate urodzony) {        this.urodzony = urodzony;    }
    public List getFilmy() {        return filmy;    }
    public void setFilmy(List filmy) {        this.filmy = filmy;    }


}
