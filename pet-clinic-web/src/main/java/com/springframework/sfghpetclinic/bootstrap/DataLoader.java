package com.springframework.sfghpetclinic.bootstrap;

import com.springframework.sfghpetclinic.model.*;
import com.springframework.sfghpetclinic.services.*;
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
    private final SpecialityService specialityService;
    private final VisitService visitService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if(count==0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType saveDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType saveCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality saveRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("surgery");
        Speciality saveSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("dentistry");
        Speciality saveDentistry = specialityService.save(dentistry);

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

        Visit catVisit = new Visit();
        catVisit.setPet(yogitsPet);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("SneeztKitty");

        visitService.save(catVisit);
        System.out.println("Loaded Owners....");

        Vet vet2 = new Vet();
        vet2.setFirstName("Sam");
        vet2.setLastName("Tarley");
        vet2.getSpecialities().add(saveRadiology);

        vetService.save(vet2);

        Vet vet1 = new Vet();
        vet1.setFirstName("Roha");
        vet1.setLastName("jackson");
        vet1.getSpecialities().add(saveSurgery);

        vetService.save(vet1);

        System.out.println("Loaded Pets...");
    }
}
