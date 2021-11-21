package fr.ul.tp_spring_h2_db;

import fr.ul.tp_spring_h2_db.model.Film;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FilmRepository extends CrudRepository<Film, Integer> {

    List<Film> findByTitle(String title);

    Film findById(int id);

    void deleteById(int id);
}
