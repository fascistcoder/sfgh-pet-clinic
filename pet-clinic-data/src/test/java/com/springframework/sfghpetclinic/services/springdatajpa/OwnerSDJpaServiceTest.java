package com.springframework.sfghpetclinic.services.springdatajpa;

import com.springframework.sfghpetclinic.model.Owner;
import com.springframework.sfghpetclinic.repositories.OwnerRepositories;
import com.springframework.sfghpetclinic.repositories.PetRepository;
import com.springframework.sfghpetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

/**
 * @author <a href="pulkit.aggarwal@upgrad.com">Pulkit Aggarwal</a>
 * @version 1.0
 * @since 22/09/21
 */
@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    public static final String LAST_NAME = "pulkit";
    @Mock
    OwnerRepositories ownerRepositories;

    @Mock
    PetRepository petRepository;

    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerSDJpaService ownerSDJpaService;

    Owner returnOwner;

    @BeforeEach
    void setUp() {
        returnOwner = Owner.builder().id(1L).lastName(LAST_NAME).build();
    }

    @Test
    void findAll() {
        Set<Owner> returnOwnerSet = new HashSet<>();
        returnOwnerSet.add(Owner.builder().id(1L).build());
        returnOwnerSet.add(Owner.builder().id(2L).build());

        when(ownerRepositories.findAll()).thenReturn(returnOwnerSet);

        Set<Owner>owners = ownerSDJpaService.findAll();

        assertEquals(2,owners.size());
    }

    @Test
    void findByID() {
        when(ownerRepositories.findById(anyLong())).thenReturn(Optional.of(returnOwner));

        Owner owner = ownerSDJpaService.findByID(1L);

        assertNotNull(owner);
    }

    @Test
    void findByIDNotFound() {
        when(ownerRepositories.findById(anyLong())).thenReturn(Optional.empty());

        Owner owner = ownerSDJpaService.findByID(1L);

        assertNull(owner);
    }

    @Test
    void save() {
        Owner ownerToSave = Owner.builder().id(1L).build();

        when(ownerRepositories.save(any())).thenReturn(returnOwner);

        Owner savedOwner = ownerSDJpaService.save(ownerToSave);

        assertNotNull(savedOwner);

        verify(ownerRepositories).save(any());
    }

    @Test
    void delete() {
        ownerSDJpaService.delete(returnOwner);
        verify(ownerRepositories,times(1)).delete(any());
    }

    @Test
    void deleteByID() {
        ownerSDJpaService.deleteByID(1L);
        verify(ownerRepositories).deleteById(anyLong());
    }

    @Test
    void findByLastName() {

        when(ownerSDJpaService.findByLastName(any())).thenReturn(returnOwner);

        Owner pulkit = ownerSDJpaService.findByLastName(LAST_NAME);

        assertEquals(LAST_NAME, pulkit.getLastName());

        verify(ownerRepositories).findByLastName(any());
    }
}