package program.entites;
import java.util.List;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.stereotype.Component;

@Node("FILM")
public class Film {
    @Id
    @GeneratedValue
    private Long id;
    private String tytuł;
    private String gatunek;
    private String produkcja;
    private Long wydany;
    @Relationship(type = "ZAGRAŁ",direction = Relationship.Direction.INCOMING)
    private List aktorzy;
    @Relationship(type = "WYREŻYSEROWAŁ",direction = Relationship.Direction.INCOMING)
    private List reżyserzy;
    @Relationship(type = "SCENARIUSZ",direction = Relationship.Direction.INCOMING)
    private List scenarzyści;



    public Long getId() {
        return id;
    }
    public List getAktorzy() {        return aktorzy;    }
    public void setAktorzy(List aktorzy) {        this.aktorzy = aktorzy;    }

    public void setId(Long id) {        this.id = id;    }

    public String getTytuł() {
        return tytuł;
    }

    public void setTytuł(String tytuł) {
        this.tytuł = tytuł;
    }

    public String getGatunek() {
        return gatunek;
    }

    public void setGatunek(String gatunek) {
        this.gatunek = gatunek;
    }

    public String getProdukcja() {
        return produkcja;
    }

    public void setProdukcja(String produkcja) {
        this.produkcja = produkcja;
    }

    public Long getWydany() {
        return wydany;
    }

    public void setWydany(Long wydany) {
        this.wydany = wydany;
    }





}
