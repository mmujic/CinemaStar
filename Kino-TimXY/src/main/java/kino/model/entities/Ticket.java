package kino.model.entities;

import javax.persistence.*;

@Table(name = "ticket")
@Entity
public class Ticket {

    private static final long serialVersionUID=123456789L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "seatX")
    private Integer seatX;

    @Column(name = "seatY")
    private Integer seatY;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user")
    private User user;

    public Ticket() {
    }

    public Ticket(Integer seatX, Integer seatY, User user) {
        this.seatX = seatX;
        this.seatY = seatY;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSeatX() {
        return seatX;
    }

    public void setSeatX(Integer seatX) {
        this.seatX = seatX;
    }

    public Integer getSeatY() {
        return seatY;
    }

    public void setSeatY(Integer seatY) {
        this.seatY = seatY;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", seatX=" + seatX +
                ", seatY=" + seatY +
                ", user=" + user +
                '}';
    }
}
