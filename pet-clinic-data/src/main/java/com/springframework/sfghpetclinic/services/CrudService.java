package com.springframework.sfghpetclinic.services;

import java.util.Set;

/**
 * @author <a href="pulkit.aggarwal@upgrad.com">Pulkit Aggarwal</a>
 * @version 1.0
 * @since 05/09/21
 */
public interface CrudService<T, ID> {
    Set<T> findAll();

    T findByID(ID id);

    T save(T object);

    void delete(T object);

    void deleteByID(ID id);

}
