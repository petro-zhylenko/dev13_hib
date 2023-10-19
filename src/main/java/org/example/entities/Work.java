package org.example.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "works")
public class Work {
    @Id
    @SequenceGenerator(name = "works",sequenceName = "works_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "works_id_seq")
    @Column(name = "id")
    private Long id;
    @Column(name = "company")
    private String company;
    @ManyToMany
    @JoinTable(
            name = "persons_works",
            joinColumns = { @JoinColumn(name = "works_id") },
            inverseJoinColumns = { @JoinColumn(name = "person_id") }
    )
    private List<Person> persons;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    @Override
    public String toString() {
        return "Work{" +
                "id=" + id +
                ", company='" + company + '\'' +
                '}';
    }
}
