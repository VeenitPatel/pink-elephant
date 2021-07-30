package com.pinkelephant.petinsurance.service;

import com.pinkelephant.petinsurance.data.OwnerRepository;
import com.pinkelephant.petinsurance.domain.Owner;
import com.pinkelephant.petinsurance.domain.Pet;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerServiceImplTest {

    @Mock
    private OwnerRepository ownerRepository;

    @InjectMocks
    private OwnerServiceImpl ownerService;


    @Test
    void getAveragePetAge() {

        List<Pet> pets = new ArrayList<>();
        pets.add(new Pet(1L, "dog", 10, "fido", "male", null));
        pets.add(new Pet(2L, "cat", 15, "mittens", "female", null));
        Owner owner = new Owner(1L, "ty", 50, "1234", "email", "phone", 1001L, pets);

        when(ownerRepository.getById(anyLong())).thenReturn(owner);

        double averageAge = ownerService.getAveragePetAge(1L);

        assertEquals(12.5, averageAge);
    }
}