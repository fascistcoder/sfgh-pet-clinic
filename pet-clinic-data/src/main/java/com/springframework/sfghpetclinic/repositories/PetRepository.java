package com.springframework.sfghpetclinic.repositories;

import com.springframework.sfghpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

/**
 * @author <a href="pulkit.aggarwal@upgrad.com">Pulkit Aggarwal</a>
 * @version 1.0
 * @since 15/09/21
 */
public interface PetRepository extends CrudRepository<Pet, Long> {
}
