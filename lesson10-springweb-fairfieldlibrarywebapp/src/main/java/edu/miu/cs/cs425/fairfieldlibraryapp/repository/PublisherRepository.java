package edu.miu.cs.cs425.fairfieldlibraryapp.repository;

// import edu.miu.cs.cs425.fairfieldlibraryapp.model.Address;
import edu.miu.cs.cs425.fairfieldlibraryapp.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Integer> {
    @Query(value = "select p from Publisher p where p.name = :name")
    Optional<Publisher> getPublisherByName(String name);

//    @Query(value = "SELECT * FROM `cs425-swe-202210-fairfieldlibrarydb`.publishers p where p.name like '%press%'", nativeQuery = true)
//    List<Publisher> getPublishersByName(String name);

    List<Publisher> findPublishersByNameEqualsIgnoreCaseAndPrimaryAddress_State(String name, String addrState);

    Optional<Publisher> findOnePublisherByName(String publisherName);

    List<Publisher> findAllByNameContainingOrPrimaryAddress_StreetContainingOrPrimaryAddress_CityContainingOrPrimaryAddress_StateContainingOrPrimaryAddress_ZipCodeContaining(
        String name, String street, String city, String state, String zipCode);
}
