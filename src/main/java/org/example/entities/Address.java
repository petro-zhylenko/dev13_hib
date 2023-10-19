package org.example.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "adresses", schema = "public")
public class Address {
  @Id
  @SequenceGenerator(name = "adresses",sequenceName = "adresses_id_seq")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "adresses")
  @Column(name = "id")
  private Long id;
  @Column(name = "street")
  private String street;
  @Column(name = "house_number")
  private Long houseNumber;
  @Column(name = "city")
  private String city;
  @Column(name = "country")
  private String country;
  @OneToMany(mappedBy = "address")
  private List<Person> personList;

  public Address(Long id, String street, Long houseNumber, String city, String country) {
    this.id = id;
    this.street = street;
    this.houseNumber = houseNumber;
    this.city = city;
    this.country = country;
  }

  public Address() {
  }

  public static AddressBuilder builder() {
    return new AddressBuilder();
  }

  public Long getId() {
    return this.id;
  }

  public String getStreet() {
    return this.street;
  }

  public Long getHouseNumber() {
    return this.houseNumber;
  }

  public String getCity() {
    return this.city;
  }

  public String getCountry() {
    return this.country;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public void setHouseNumber(Long houseNumber) {
    this.houseNumber = houseNumber;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public static class AddressBuilder {
    private Long id;
    private String street;
    private Long houseNumber;
    private String city;
    private String country;

    AddressBuilder() {
    }

    public AddressBuilder id(Long id) {
      this.id = id;
      return this;
    }

    public AddressBuilder street(String street) {
      this.street = street;
      return this;
    }

    public AddressBuilder houseNumber(Long houseNumber) {
      this.houseNumber = houseNumber;
      return this;
    }

    public AddressBuilder city(String city) {
      this.city = city;
      return this;
    }

    public AddressBuilder country(String country) {
      this.country = country;
      return this;
    }

    public Address build() {
      return new Address(this.id, this.street, this.houseNumber, this.city, this.country);
    }

    public String toString() {
      return "Address.AddressBuilder(id=" + this.id + ", street=" + this.street + ", houseNumber=" + this.houseNumber + ", city=" + this.city + ", country=" + this.country + ")";
    }
  }

  @Override
  public String toString() {
    return "Address{" +
            "id=" + id +
            ", street='" + street + '\'' +
            ", houseNumber=" + houseNumber +
            ", city='" + city + '\'' +
            ", country='" + country + '\'' +
            '}';
  }
}
