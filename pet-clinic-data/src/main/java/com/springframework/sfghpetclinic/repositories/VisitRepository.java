package com.springframework.sfghpetclinic.repositories;

import com.springframework.sfghpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

/**
 * @author <a href="pulkit.aggarwal@upgrad.com">Pulkit Aggarwal</a>
 * @version 1.0
 * @since 18/09/21
 */
public interface VisitRepository extends CrudRepository<Visit, Long> {
}
