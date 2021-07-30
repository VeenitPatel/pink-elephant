package com.pinkelephant.petinsurance.service;

import com.pinkelephant.petinsurance.data.OwnerRepository;
import com.pinkelephant.petinsurance.data.PetRepository;
import com.pinkelephant.petinsurance.domain.Owner;
import com.pinkelephant.petinsurance.domain.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class OwnerServiceImpl implements OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private PetRepository petRepository;

    @Override
    public List<Owner> getAllOwner() {
        return ownerRepository.findAll();
    }

    @Override
    public Owner getOwnerById(Long id) {
        return ownerRepository.findById(id).get();
    }

    @Override
    public Owner createOwner(Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    public Owner updateOwner(Long id, Owner owner) {
        Owner oldOwner = getOwnerById(id);
        oldOwner.setAddress(owner.getAddress());
        oldOwner.setAge(owner.getAge());
        oldOwner.setEmail(owner.getEmail());
        oldOwner.setName(owner.getName());
        oldOwner.setPhone(owner.getPhone());
        oldOwner.setPolicyNumber(owner.getPolicyNumber());
        return ownerRepository.save(oldOwner);
    }

    @Override
    public void deleteOwner(Long id) {
        ownerRepository.deleteById(id);
    }

    @Override
    public List<Pet> getAllPetsForOwner(Long id) {
        return ownerRepository.getById(id).getPets();
    }

    @Override
    public Double getAveragePetAge(Long id) {
        List<Pet> pets = ownerRepository.getById(id).getPets();
        Double total = 0.0;
        for (Pet pet: pets) {
            total += pet.getAge();
        }
        return total/pets.size();
    }


}
