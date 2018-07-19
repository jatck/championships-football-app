package pl.kz.championshipsfootballapp;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.kz.championshipsfootballapp.repo.GrupyRepository;

@Controller
public class StartController {
	

    @RequestMapping("/")
    @ResponseBody
    String index() {
        return "Cześć, uczymy się programować!";
    }
    
    @RequestMapping("/grzesiek")
    @ResponseBody
    String index1() {
        return "Cześć, uczymy Grześka programować!";
    }

}