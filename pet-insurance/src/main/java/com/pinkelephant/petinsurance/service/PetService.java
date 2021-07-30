package com.pinkelephant.petinsurance.service;

import com.pinkelephant.petinsurance.domain.Pet;

import java.util.List;

public interface PetService {
    List<Pet> getAllPet();

    Pet getPetById(Long id);

    Pet createPet(Pet pet);

    Pet updatePet(Long id, Pet pet);

    void deletePet(Long id);

    List<Pet> getAllBySpecies(String species);

    List<Pet> getAllByGender(String gender);
}
