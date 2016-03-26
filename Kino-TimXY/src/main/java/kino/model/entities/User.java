package kino.model.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Table(name = "user")
@Entity
public class User implements Serializable {

    private static final long serialVersionUID=123456789L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String number;

    @Column(name = "adminFlag")
    private boolean admin;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();

    //@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    //private List<Ticket>tickets=new ArrayList<>();

    public User() {
    }

    //public List<Ticket> getTickets() {
    //    return tickets;
    //}

    //public void setTickets(List<Ticket> tickets) {
    //    this.tickets = tickets;
    //}

    public User(String name, String address, String email, String number, boolean admin) {
        this.name = name;
        this.address = address;

        this.email = email;
        this.number = number;
        this.admin = admin;
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

    public void setName(String firsName) {
        this.name = firsName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", number='" + number + '\'' +
                ", admin=" + admin +
                ", comments=" + comments +
                //", tickets=" + tickets +
                '}';
    }
}
