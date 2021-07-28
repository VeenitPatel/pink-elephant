package com.pinkelephant.petinsurance.data;

import com.pinkelephant.petinsurance.domain.Owner;
import com.pinkelephant.petinsurance.domain.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {
}
