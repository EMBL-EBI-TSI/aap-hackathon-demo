package uk.ac.ebi.tsc.aap.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by neilg on 03/05/2017.
 */

@Controller
@SpringBootApplication
public class HelloWorldController {

    @RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
    @ResponseBody
    public String welcomePage() {
        return "Wellcome";
    }


    @RequestMapping(value = { "/hello**" }, method = RequestMethod.GET)
    @ResponseBody
    public String hello() {
        return "Hello";
    }

    @PreAuthorize("hasRole('AAPAdmin')")
    @RequestMapping(value = "/admin**", method = RequestMethod.GET)
    @ResponseBody
    public String adminPage() {
        return "Admin";
    }

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication( HelloWorldController.class);
        springApplication.run(args);
    }

}