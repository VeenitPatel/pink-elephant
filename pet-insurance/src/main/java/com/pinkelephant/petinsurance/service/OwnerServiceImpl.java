package com.pinkelephant.petinsurance.service;

import com.pinkelephant.petinsurance.data.OwnerRepository;
import com.pinkelephant.petinsurance.domain.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class OwnerServiceImpl implements OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;

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


}
