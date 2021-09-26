package com.springframework.sfghpetclinic.services.springdatajpa;

import com.springframework.sfghpetclinic.model.Owner;
import com.springframework.sfghpetclinic.repositories.OwnerRepositories;
import com.springframework.sfghpetclinic.repositories.PetRepository;
import com.springframework.sfghpetclinic.repositories.PetTypeRepository;
import com.springframework.sfghpetclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author <a href="pulkit.aggarwal@upgrad.com">Pulkit Aggarwal</a>
 * @version 1.0
 * @since 17/09/21
 */
@Service
@Profile("springdatajpa")
public class OwnerSDJpaService implements OwnerService {

    private final OwnerRepositories ownerRepositories;
    private final PetRepository petRepository;
    private final PetTypeRepository petTypeRepository;

    public OwnerSDJpaService(OwnerRepositories ownerRepositories, PetRepository petRepository,
                             PetTypeRepository petTypeRepository) {
        this.ownerRepositories = ownerRepositories;
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownerRepositories.findAll().forEach(owners::add);
        return owners;
    }

    @Override
    public Owner findByID(Long aLong) {
        return ownerRepositories.findById(aLong).orElse(null);
    }

    @Override
    public Owner save(Owner object){
        return ownerRepositories.save(object);
    }

    @Override
    public void delete(Owner object) {
        ownerRepositories.delete(object);
    }

    @Override
    public void deleteByID(Long aLong) {
        ownerRepositories.deleteById(aLong);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepositories.findByLastName(lastName);
    }

    @Override
    public List<Owner> findAllByLastNameLike(String lastName) {
        return ownerRepositories.findAllByLastNameLike(lastName);
    }
}
