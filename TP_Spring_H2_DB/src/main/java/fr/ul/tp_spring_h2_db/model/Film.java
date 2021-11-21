package fr.ul.tp_spring_h2_db.model;

import javax.persistence.*;

@Entity
public class Film {

    private String title;
    private String synopsis;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    protected Film(){}

    public Film(String title, String synopsis, int id) {
        this.title = title;
        this.synopsis = synopsis;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
