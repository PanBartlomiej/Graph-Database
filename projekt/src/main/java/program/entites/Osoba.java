package program.entites;

import org.neo4j.driver.internal.shaded.io.netty.handler.codec.DateFormatter;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;

@Node("OSOBA")
public class Osoba {
    @Id
    @GeneratedValue
    private Long id;
    private String imie;
    private String nazwisko;
    private String kraj;
    private Long wzrost;

    public List getAktorzy() {
        return aktorzy;
    }

    public void setAktorzy(List aktorzy) {
        this.aktorzy = aktorzy;
    }

    @Relationship(type = "ZAGRAŁ",direction = Relationship.Direction.OUTGOING)
    private List aktorzy;
    @Relationship(type = "WYREŻYSEROWAŁ",direction = Relationship.Direction.OUTGOING)
    private List reżyserzy;
    @Relationship(type = "SCENARIUSZ",direction = Relationship.Direction.OUTGOING)
    private List scenarzyści;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getKraj() {
        return kraj;
    }

    public void setKraj(String kraj) {
        this.kraj = kraj;
    }

    public Long getWzrost() {
        return wzrost;
    }

    public void setWzrost(Long wzrost) {
        this.wzrost = wzrost;
    }

    public DateFormatter getUrodzony() {
        return urodzony;
    }

    public void setUrodzony(DateFormatter urodzony) {
        this.urodzony = urodzony;
    }

    private DateFormatter urodzony;
}
