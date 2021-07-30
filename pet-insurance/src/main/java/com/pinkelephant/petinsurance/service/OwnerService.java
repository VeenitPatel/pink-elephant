package com.pinkelephant.petinsurance.service;

import com.pinkelephant.petinsurance.domain.Owner;
import com.pinkelephant.petinsurance.domain.Pet;

import java.util.List;

public interface OwnerService {
    List<Owner> getAllOwner();

    Owner getOwnerById(Long id);

    Owner createOwner(Owner owner);

    Owner updateOwner(Long id, Owner owner);

    void deleteOwner(Long id);

    List<Pet> getAllPetsForOwner(Long id);

    Double getAveragePetAge(Long id);
}
