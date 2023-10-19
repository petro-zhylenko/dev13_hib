package org.example.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "contacts")
public class Contact {
  @Id
  @SequenceGenerator(name = "contact",sequenceName = "contacts_id_seq")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contact")
  @Column(name = "id")
  private Long id;
  @Column(name = "phone")
  private String phone;
  @Column(name = "email")
  private String email;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String toString() {
    return "Contact{" +
            "id=" + id +
            ", phone='" + phone + '\'' +
            ", email='" + email + '\'' +
            '}';
  }
}
