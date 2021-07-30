package com.pinkelephant.petinsurance.service;

import com.pinkelephant.petinsurance.data.PetRepository;
import com.pinkelephant.petinsurance.data.PetRepository;
import com.pinkelephant.petinsurance.domain.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetServiceImpl implements PetService {

    @Autowired
    private PetRepository petRepository;

    @Override
    public List<Pet> getAllPet() {
        return petRepository.findAll();
    }

    @Override
    public Pet getPetById(Long id) {
        return petRepository.findById(id).get();
    }

    @Override
    public Pet createPet(Pet pet) {
        return petRepository.save(pet);
    }

    @Override
    public Pet updatePet(Long id, Pet pet) {
        Pet oldPet = getPetById(id);
        oldPet.setAge(pet.getAge());
        oldPet.setGender(pet.getGender());
        oldPet.setSpecies(pet.getSpecies());
        oldPet.setName(pet.getName());
        oldPet.setOwner(pet.getOwner());
        return petRepository.save(oldPet);
    }

    @Override
    public void deletePet(Long id) {
        petRepository.deleteById(id);
    }

    @Override
    public List<Pet> getAllBySpecies(String species) {
        return petRepository.findAllBySpecies(species);
    }

    @Override
    public List<Pet> getAllByGender(String gender) {
        return petRepository.findAllByGender(gender);
    }


}
