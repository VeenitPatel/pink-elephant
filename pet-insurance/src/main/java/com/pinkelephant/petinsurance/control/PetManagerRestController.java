package com.pinkelephant.petinsurance.control;

import com.pinkelephant.petinsurance.domain.Owner;
import com.pinkelephant.petinsurance.service.PetManagerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class PetManagerRestController {

    @Autowired
    private PetManagerUtils service;

    @GetMapping("/health")
    public String systemIsHealthy() {
        return "OK";
    }

    @GetMapping("/owner")
    public List<Owner> getAllOwners() {
        return service.getAllOwner();
    }

    @GetMapping("/owner/{id}")
    public Owner getOwnerById(@PathVariable Long id) {
        return service.getOwnerById(id);
    }
}