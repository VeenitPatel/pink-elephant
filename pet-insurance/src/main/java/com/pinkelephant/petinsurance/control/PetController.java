package com.pinkelephant.petinsurance.control;

import com.pinkelephant.petinsurance.domain.Pet;
import com.pinkelephant.petinsurance.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/pet")
public class PetController {

    @Autowired
    private PetService service;

    @GetMapping()
    public List<Pet> getAllPets() {
        return service.getAllPet();
    }

    @GetMapping("/{id}")
    public Pet getPetById(@PathVariable Long id) {
        return service.getPetById(id);
    }

    @PostMapping()
    public Pet addPet(@RequestBody Pet pet) {
        return service.createPet(pet);
    }
}
