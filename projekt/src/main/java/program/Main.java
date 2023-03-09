package program;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import program.services.FilmService;

@SpringBootApplication
@ComponentScan(basePackages = {
        "program.controler",
        "program.services",
        "program.repositories",
        "program.entites"
})
public class Main {
    public static void main(String[] args) {
      //  System.out.println(new Main().filmService.getAll());
        SpringApplication.run(Main.class, args);
    }

}
