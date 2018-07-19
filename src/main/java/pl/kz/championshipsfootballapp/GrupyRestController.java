package pl.kz.championshipsfootballapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import pl.kz.championshipsfootballapp.repo.GrupyRepository;
import pl.kz.championshipsfootballapp.model.Grupy;


@RestController
public class GrupyRestController {
    GrupyRepository grupyRepository;

    public GrupyRestController(GrupyRepository grupyRespositoy) {
        this.grupyRepository = grupyRepository;
    }

    @GetMapping(value="/api/grupy")
    public List<Grupy> getGrupy() {
        return this.grupyRepository.findAll();
    }

    @GetMapping(value="/api/grupy/{id}")
    public Grupy getGrupa(@PathVariable(value="id") long id) {
        return this.grupyRepository.findById(id);//findOne(id);
    }
}