package com.pinkelephant.petinsurance.control;

import com.google.common.collect.Maps;
import com.pinkelephant.petinsurance.domain.Owner;
import com.pinkelephant.petinsurance.domain.Pet;
import com.pinkelephant.petinsurance.service.OwnerService;
import com.pinkelephant.petinsurance.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api/owner")
public class OwnerController {

    @Autowired
    private OwnerService service;

    @Autowired
    private PetService petService;

    @GetMapping()
    public List<Owner> getAllOwners() {
        return service.getAllOwner();
    }

    @GetMapping("/{id}")
    public Owner getOwnerById(@PathVariable Long id) {
        return service.getOwnerById(id);
    }

    @PostMapping()
    public Owner addOwner(@RequestBody Owner owner) {
        return service.createOwner(owner);
    }

    @PutMapping("{id}")
    public Owner updateOwner(@RequestBody Owner owner, @PathVariable Long id) {
        return service.updateOwner(id, owner);
    }

    @DeleteMapping("/{id}")
    public void deleteOwner(@PathVariable Long id) { service.deleteOwner(id); }

    @GetMapping("/{id}/pet")
    public List<Pet> getAllPets(@PathVariable Long id) {
        return service.getAllPetsForOwner(id);
    }

    @GetMapping("/{id}/pet/{petId}")
    public Pet getPet(@PathVariable Long id, @PathVariable Long petId) {
        return petService.getPetById(petId);
    }

    @GetMapping("{id}/average-pet-age")
    public Map<String,Double> getAverageAges(@PathVariable Long id) {
        Map map = new HashMap();
        map.put("Average", service.getAveragePetAge(id));
        return map;
    }

    @PostMapping("/{id}/pet")
    public Owner addPetToOwner(@PathVariable Long id, @RequestBody Pet pet) {
        Owner owner = getOwnerById(id);
        pet.setOwner(owner);
        petService.createPet(pet);

        return owner;
    }

    @DeleteMapping("/{id}/pet/{petId}")
    public void deletePetFromOwner(@PathVariable Long id, @PathVariable Long petId) {
        petService.deletePet(petId);
    }
}