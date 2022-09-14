package mx.com.hiringa.sga.jpql.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "users")
@NamedQueries({
        @NamedQuery(name = "FindAllUsers", query = "select u from User u order by u.id"),
        @NamedQuery(name = "FindUserByID", query = "select u from User u where u.id = :id"),
        @NamedQuery(name = "FindUserByUsername", query = "select u from User u where u.username = :username"),
        @NamedQuery(name = "FindUserByPersonID", query = "select u from User u where u.person = :person")
})
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "username", nullable = false, length = 30)
    private String username;

    @NotNull
    @Column(name = "password", nullable = false, length = 50)
    private String password;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private Person person;

    public User() {}

    public User(Integer id) { this.id = id; }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, Person person) {
        this.username = username;
        this.password = password;
        this.person = person;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                Objects.equals(person, user.person);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, person);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", person=" + person +
                '}';
    }
}
