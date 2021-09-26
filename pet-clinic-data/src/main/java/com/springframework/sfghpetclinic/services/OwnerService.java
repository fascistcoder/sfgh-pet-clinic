package com.springframework.sfghpetclinic.services;

import com.springframework.sfghpetclinic.model.Owner;

import java.util.List;

/**
 * @author <a href="pulkit.aggarwal@upgrad.com">Pulkit Aggarwal</a>
 * @version 1.0
 * @since 03/09/21
 */
public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);
}
