package program.entites;

import org.neo4j.driver.internal.shaded.io.netty.handler.codec.DateFormatter;
import org.springframework.data.neo4j.core.schema.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Node("AKTOR")
public class Aktor {
    @Id
    @GeneratedValue
    private Long id;
    private String imie;
    private String nazwisko;
    private String kraj;
    private Long wzrost;
    private LocalDate urodzony;
    @Relationship(type = "ZAGRAŁ",direction = Relationship.Direction.OUTGOING)
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


    @Override
    public String toString() {
        return "Aktor{" +
                "id=" + id +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", kraj='" + kraj + '\'' +
                ", wzrost=" + wzrost +
                ", urodzony=" + urodzony +
                ", filmy=" + filmy +
                '}';
    }
}
