package edu.miu.cs.cs425.fairfieldlibraryapp.model;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name="addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer addressId;
    private String street;
    private String city;
    private String state;
    private String zipCode;

    @OneToOne(mappedBy = "primaryAddress")
    private Publisher publisher;

    @Override
    public String toString() {
        return String.format("AddressId: %d, Street: %s, City: %s, State: %s, ZipCode: %s",
                addressId, street, city, state, zipCode);
    }
}
