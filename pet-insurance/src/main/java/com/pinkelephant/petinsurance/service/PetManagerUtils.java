package com.pinkelephant.petinsurance.service;

import com.pinkelephant.petinsurance.domain.Owner;

import java.util.List;

public interface PetManagerUtils {
    List<Owner> getAllOwner();

    Owner getOwnerById(Long id);
}
