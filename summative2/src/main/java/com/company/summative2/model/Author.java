package com.company.summative2.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@JsonIgnoreProperties({"hibernateInitializer", "handler"})
@Table(name = "author")
public class Author implements Serializable {

    @Id
    @Column(name = "authorId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int authorId;

    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String state;
    private String postalCode;
    private String phone;
    private String email;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "bookId")
    private Set<Book> books = new HashSet<>();


    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(getAuthorId(), author.getAuthorId()) && Objects.equals(getFirstName(), author.getFirstName()) && Objects.equals(getLastName(), author.getLastName()) && Objects.equals(getStreet(), author.getStreet()) && Objects.equals(getCity(), author.getCity()) && Objects.equals(getState(), author.getState()) && Objects.equals(getPostalCode(), author.getPostalCode()) && Objects.equals(getPhone(), author.getPhone()) && Objects.equals(getEmail(), author.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAuthorId(), getFirstName(), getLastName(), getStreet(), getCity(), getState(), getPostalCode(), getPhone(), getEmail());
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorId=" + authorId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
