package com.springframework.sfghpetclinic.repositories;

import com.springframework.sfghpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author <a href="pulkit.aggarwal@upgrad.com">Pulkit Aggarwal</a>
 * @version 1.0
 * @since 15/09/21
 */
public interface OwnerRepositories extends CrudRepository<Owner, Long> {
    Owner findByLastName(String lastName);

    List<Owner>findAllByLastNameLike(String lastName);

}
