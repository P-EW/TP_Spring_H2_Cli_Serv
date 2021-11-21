package fr.ul.tp_spring_h2_db;

import fr.ul.tp_spring_h2_db.model.Film;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
public class TpSpringH2DbApplication {

    private static final Logger log = LoggerFactory.getLogger(TpSpringH2DbApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(TpSpringH2DbApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(FilmRepository repository){
        return (args -> {
            //Creation de films selectionnés pour le Festival de Cannes
            repository.save(new Film("Le retour du jeudi", "Chaque semaine, c'est la même galère, il y a un jeudi.", 1));
            repository.save(new Film("Pêche à pieds avec Spring Boot","Aujourd'hui nous allons pêcher avec nos nouvelles bottes !", 2));
            repository.save(new Film("Le mask","Le port du masque, toujours et encore, premier pas vers le confinement...",3));
            repository.save(new Film("Les développeurs de l'extrême","Cette année encore les élèves de Master 2 IL doivent se démener pour rendre les projets à temps, le repos n'est déjà plus qu'un vague souvenir.",4));


            /*
            log.info("Affichage de tout les films: (findAll)");
            repository.findAll().forEach(film -> System.out.println(film.getTitle()));

            log.info("Affichage d'un seul Film par id (findOne)");
            System.out.println(repository.findById(2).getTitle());

            log.info("Affichage par de films par titre (findByTitle)");
            repository.findByTitle("Le mask").forEach(film -> System.out.println(film.getTitle()));
            */
        });
    }
}
