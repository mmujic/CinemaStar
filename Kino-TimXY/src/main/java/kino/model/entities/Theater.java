package kino.model.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ekusundzija on 3/14/16.
 */
public class Theater {

    private static final long serialVersionUID = 123456782L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "sizeX")
    private Integer sizeX;

    @Column(name = "sizeY")
    private Integer sizeY;

    @OneToMany(mappedBy = "theatre", cascade = CascadeType.ALL)
    private List<Screening> screenings = new ArrayList<>();

    public Theater() {
    }

    public Theater(String name, Integer sizeX, Integer sizeY, List<Screening> screenings) {
        this.name = name;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.screenings = screenings;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSizeX() {
        return sizeX;
    }

    public void setSizeX(Integer sizeX) {
        this.sizeX = sizeX;
    }

    public Integer getSizeY() {
        return sizeY;
    }

    public void setSizeY(Integer sizeY) {
        this.sizeY = sizeY;
    }

    public List<Screening> getScreenings() {
        return screenings;
    }

    public void setScreenings(List<Comment> screening) {
        this.screenings = screenings;
    }

    @Override
    public String toString() {
        return "Theater{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sizeX=" + sizeX +
                ", sizeY=" + sizeY +
                ", screenings=" + screenings +
                '}';
    }
}


