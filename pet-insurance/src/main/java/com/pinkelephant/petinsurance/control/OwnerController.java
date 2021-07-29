package com.pinkelephant.petinsurance.control;

import com.pinkelephant.petinsurance.domain.Owner;
import com.pinkelephant.petinsurance.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/owner")
public class OwnerController {

    @Autowired
    private OwnerService service;

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
}