package com.springframework.sfghpetclinic.bootstrap;

import com.springframework.sfghpetclinic.model.Owner;
import com.springframework.sfghpetclinic.model.Vet;
import com.springframework.sfghpetclinic.services.OwnerService;
import com.springframework.sfghpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author <a href="pulkit.aggarwal@upgrad.com">Pulkit Aggarwal</a>
 * @version 1.0
 * @since 06/09/21
 */
@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner = new Owner();
        owner.setFirstName("Pulkit");
        owner.setLastName("Aggarwal");
        ownerService.save(owner);

        Owner owner2 = new Owner();
        owner2.setFirstName("Yogita");
        owner2.setLastName("Aggarwal");
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