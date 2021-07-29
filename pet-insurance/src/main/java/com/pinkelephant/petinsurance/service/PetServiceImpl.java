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
}
