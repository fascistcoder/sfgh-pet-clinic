package com.springframework.sfghpetclinic.services;

import com.springframework.sfghpetclinic.model.Owner;

import java.util.Set;

/**
 * @author <a href="pulkit.aggarwal@upgrad.com">Pulkit Aggarwal</a>
 * @version 1.0
 * @since 03/09/21
 */
public interface OwnerService {
    Owner findByLateName(String lastName);

    Owner findById(Long id);

    Owner save(Owner owner);

    Set<Owner> findAll();
}
