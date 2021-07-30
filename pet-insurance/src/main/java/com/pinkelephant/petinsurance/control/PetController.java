package com.pinkelephant.petinsurance.control;

import com.pinkelephant.petinsurance.domain.Owner;
import com.pinkelephant.petinsurance.domain.Pet;
import com.pinkelephant.petinsurance.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/api/pet")
public class PetController {

    @Autowired
    private PetService service;

    @GetMapping()
    public List<Pet> getAllPets(
            @RequestParam(value = "species", required = false) String species,
            @RequestParam(value = "gender", required = false) String gender)
    {
        if (species != null && gender != null) {
            List<Pet> petsBySpecies = service.getAllBySpecies(species);
            List<Pet> petsByGender = service.getAllByGender(gender);
            return petsBySpecies.stream()
                    .distinct()
                    .filter(petsByGender::contains)
                    .collect(Collectors.toList());
        }
        else if (species != null) {
            return service.getAllBySpecies(species);
        }
        else if (gender != null) {
            return service.getAllByGender(gender);
        }
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

    @PutMapping("/{id}")
    public Pet updatePet(@RequestBody Pet pet, @PathVariable Long id) {
        return service.updatePet(id, pet);
    }

    @DeleteMapping("/{id}")
    public void deletePet(@PathVariable Long id) { service.deletePet(id); }

}
