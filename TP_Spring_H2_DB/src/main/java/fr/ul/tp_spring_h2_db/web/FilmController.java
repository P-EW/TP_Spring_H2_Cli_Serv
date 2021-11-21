package fr.ul.tp_spring_h2_db.web;

import fr.ul.tp_spring_h2_db.FilmRepository;
import fr.ul.tp_spring_h2_db.model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class FilmController {

    @Autowired
    private FilmRepository filmRepository;

    @GetMapping(value ="/films")
    public Iterable<Film> getFilmList() {
        return filmRepository.findAll();
    }

    @GetMapping(value ="/film/{id}")
    public Film getFilm(@PathVariable int id){
        return filmRepository.findById(id);
    }

    @PostMapping(value = "film")
    public void addFilm(@RequestBody Film f){
        filmRepository.save(f);
    }

    @GetMapping(value ="/films/{title}")
    public List<Film> getFilmByTitle(@PathVariable String title){
        return filmRepository.findByTitle(title);
    }

    @DeleteMapping(value ="/film/{id}")
    public void deleteFilm(@PathVariable int id){
        filmRepository.deleteById(id);
    }

    @PutMapping(value="/film")
    public void updateFilm(@RequestBody Film f){
        filmRepository.save(f);
    }
}
