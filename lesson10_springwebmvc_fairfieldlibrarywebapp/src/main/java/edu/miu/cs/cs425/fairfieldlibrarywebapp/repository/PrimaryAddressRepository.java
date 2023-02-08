package edu.miu.cs.cs425.fairfieldlibrarywebapp.repository;

import edu.miu.cs.cs425.fairfieldlibrarywebapp.model.PrimaryAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrimaryAddressRepository extends JpaRepository<PrimaryAddress, Integer> {
}
