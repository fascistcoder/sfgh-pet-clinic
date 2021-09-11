package com.springframework.sfghpetclinic.bootstrap;

import com.springframework.sfghpetclinic.model.Owner;
import com.springframework.sfghpetclinic.model.Pet;
import com.springframework.sfghpetclinic.model.PetType;
import com.springframework.sfghpetclinic.model.Vet;
import com.springframework.sfghpetclinic.services.OwnerService;
import com.springframework.sfghpetclinic.services.PetTypeService;
import com.springframework.sfghpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * @author <a href="pulkit.aggarwal@upgrad.com">Pulkit Aggarwal</a>
 * @version 1.0
 * @since 06/09/21
 */
@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType saveDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType saveCatPetType = petTypeService.save(cat);

        Owner owner = new Owner();
        owner.setFirstName("Pulkit");
        owner.setLastName("Aggarwal");
        owner.setAddress("Nai Basti");
        owner.setCity("Rewari");
        owner.setTelephone("123123123");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(saveDogPetType);
        mikesPet.setOwner(owner);
        mikesPet.setLocalDate(LocalDate.now());
        mikesPet.setName("Rascal");
        owner.getPets().add(mikesPet);

        ownerService.save(owner);

        Owner owner2 = new Owner();
        owner2.setFirstName("Yogita");
        owner2.setLastName("Aggarwal");
        owner2.setAddress("Nai Basti");
        owner2.setCity("Rewari");
        owner2.setTelephone("123123444");

        Pet yogitsPet = new Pet();
        yogitsPet.setPetType(saveDogPetType);
        yogitsPet.setOwner(owner2);
        yogitsPet.setLocalDate(LocalDate.now());
        yogitsPet.setName("elol");
        owner2.getPets().add(yogitsPet);

        ownerService.save(owner2);

        System.out.println("Loaded Owners....");

        Vet vet2 = new Vet();
        vet2.setFirstName("Sam");
        vet2.setLastName("Tarley");
        vetService.save(vet2);


        Vet vet1 = new Vet();
        vet1.setFirstName("Roha");
        vet1.setLastName("jackson");
        vetService.save(vet1);

        System.out.println("Loaded Pets...");
    }
}
