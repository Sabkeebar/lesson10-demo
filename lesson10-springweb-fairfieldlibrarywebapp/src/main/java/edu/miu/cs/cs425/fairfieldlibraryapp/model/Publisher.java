package edu.miu.cs.cs425.fairfieldlibraryapp.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="publishers")
@NamedQuery(name="Publisher.findOnePublisherByName", query = "select p from Publisher p where p.name = ?1")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer publisherId;

    @Column(nullable = false)
    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "primary_address_id", nullable = true)
    private Address primaryAddress;
//    @OneToMany(mappedBy = "publisher")
//    private List<Book> books;

    public Publisher() {
    }

    public Publisher(Integer publisherId, String name) {
        this.publisherId = publisherId;
        this.name = name;
    }

    public Publisher(Integer publisherId, String name, Address primaryAddress) {
        this.publisherId = publisherId;
        this.name = name;
        this.primaryAddress = primaryAddress;
    }

    public Integer getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Integer publisherId) {
        this.publisherId = publisherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getPrimaryAddress() {
        return primaryAddress;
    }

    public void setPrimaryAddress(Address primaryAddress) {
        this.primaryAddress = primaryAddress;
    }

    @Override
    public String toString() {
        return String.format("PublisherId: %d, Name: %s, PrimaryAddress: %s", this.publisherId, this.name, this.primaryAddress);
    }
}
