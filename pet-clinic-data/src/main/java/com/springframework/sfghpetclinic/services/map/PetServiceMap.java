package com.springframework.sfghpetclinic.services.map;

import com.springframework.sfghpetclinic.model.Pet;
import com.springframework.sfghpetclinic.services.PetService;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author <a href="pulkit.aggarwal@upgrad.com">Pulkit Aggarwal</a>
 * @version 1.0
 * @since 05/09/21
 */
@Service
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {
    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Pet object) {
        super.delete(object);
    }

    @Override
    public Pet findByID(Long id) {
        return super.findById(id);
    }

    @Override
    public Pet save(Pet object) {return super.save(object);}

    @Override
    public void deleteByID(Long id) {super.deleteById(id);}
}
