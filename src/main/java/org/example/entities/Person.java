package org.example.entities;

import jakarta.persistence.*;
import lombok.ToString;

import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "persons")
public class Person {
  @Id
  @SequenceGenerator(name = "persons",sequenceName = "persons_id_seq")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "persons")
  @Column(name = "id")
  private Long id;
  @Column(name = "adress_id", insertable = false, updatable = false)
  private Long addressId;
  @ManyToOne
  @JoinColumn(name = "adress_id")
  private Address address;
  @Column(name = "first_name")
  private String firstName;
  @Column(name = "second_name")
  private String secondName;
  @Column(name = "gender_id")
  private Long genderId;
  @OneToOne
  @JoinColumn(name = "contatcs_id")
  private Contact contact;
  @ManyToMany
  @JoinTable(
          name = "persons_works",
          joinColumns = { @JoinColumn(name = "person_id") },
          inverseJoinColumns = { @JoinColumn(name = "works_id") }
  )
  private List<Work> works;

  public List<Work> getWorks() {
    return works;
  }

  public void setWorks(List<Work> works) {
    this.works = works;
  }

  public Address getAddress() {
    return address;
  }

  public Contact getContact() {
    return contact;
  }

  public void setContact(Contact contact) {
    this.contact = contact;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public Person(Long id, Long addressId, String firstName, String secondName, Long genderId, Address address) {
    this.id = id;
    this.addressId = addressId;
    this.firstName = firstName;
    this.secondName = secondName;
    this.genderId = genderId;
    this.address = address;
  }

  public Person() {

  }

  public static PersonBuilder builder() {
    return new PersonBuilder();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getAddressId() {
    return addressId;
  }

  public void setAddressId(Long addressId) {
    this.addressId = addressId;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getSecondName() {
    return secondName;
  }

  public void setSecondName(String secondName) {
    this.secondName = secondName;
  }

  public Long getGenderId() {
    return genderId;
  }

  public void setGenderId(Long genderId) {
    this.genderId = genderId;
  }

  public static class PersonBuilder {
    private Long id;
    private Long addressId;
    private Address address;
    private String firstName;
    private String secondName;
    private Long genderId;

    PersonBuilder() {
    }

    public PersonBuilder id(Long id) {
      this.id = id;
      return this;
    }

    public PersonBuilder addressId(Long addressId) {
      this.addressId = addressId;
      return this;
    }

    public PersonBuilder firstName(String firstName) {
      this.firstName = firstName;
      return this;
    }

    public PersonBuilder address(Address address) {
      this.address = address;
      return this;
    }

    public PersonBuilder secondName(String secondName) {
      this.secondName = secondName;
      return this;
    }

    public PersonBuilder genderId(Long genderId) {
      this.genderId = genderId;
      return this;
    }

    public Person build() {
      return new Person(this.id, this.addressId, this.firstName, this.secondName, this.genderId, this.address);
    }

    public String toString() {
      return "Person.PersonBuilder(id=" + this.id + ", addressId=" + this.addressId + ", firstName=" + this.firstName + ", secondName=" + this.secondName + ", genderId=" + this.genderId + ")";
    }
  }

  @Override
  public String toString() {
    return "Person id=%s, addressId=%s, address=%s, firstName=%s, secondName=%s, genderId=%s, contact=%s, works=%s"
            .formatted(id,addressId,address.toString(),firstName,secondName,genderId,contact, Arrays.toString(works.toArray()));
  }
}
