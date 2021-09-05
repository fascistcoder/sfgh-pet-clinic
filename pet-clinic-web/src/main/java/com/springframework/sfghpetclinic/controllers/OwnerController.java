package com.springframework.sfghpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author <a href="pulkit.aggarwal@upgrad.com">Pulkit Aggarwal</a>
 * @version 1.0
 * @since 05/09/21
 */
@Controller
public class OwnerController {
    @RequestMapping({"/owners", "/owners/index", "/owners/index.html"})
    public String listVets() {
        return "owners/index";
    }
}
