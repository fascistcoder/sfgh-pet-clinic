package com.springframework.sfghpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author <a href="pulkit.aggarwal@upgrad.com">Pulkit Aggarwal</a>
 * @version 1.0
 * @since 05/09/21
 */
@Controller
public class IndexController {

    @RequestMapping({"","/","index","index.html"})
    public String index() {
        return "index";
    }
}
