package mx.com.hiringa.transactions.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "persons")
@NamedQueries({
        @NamedQuery(name = "FindAllPersons", query = "select p from Person p order by p.id"),
        @NamedQuery(name = "FindPersonByName", query = "select p from Person p where p.name = :name"),
        @NamedQuery(name = "FindPersonByLastName", query = "select p from Person p where p.lastName = :lastName"),
        @NamedQuery(name = "FindPersonByEmail", query = "select p from Person p where p.email = :email")
})
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "phone", length = 13)
    private String phone;

    public Person() {}

    public Person(String name, String lastName, String email, String phone) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) &&
                Objects.equals(name, person.name) &&
                Objects.equals(lastName, person.lastName) &&
                Objects.equals(email, person.email) &&
                Objects.equals(phone, person.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastName, email, phone);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}