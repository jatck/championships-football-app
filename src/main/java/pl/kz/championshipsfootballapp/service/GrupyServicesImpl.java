package pl.kz.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kz.model.Grupy;
import pl.kz.repository.GrupyRepository;

/**
 * Created by JACZAW on 29.05.2018.
 */
@Service
public class GrupyServicesImpl implements GrupyServices {


    @Autowired
    private GrupyRepository grupyRepository;

    @Override
    public List<String> getAllGrupy(long id) {
        List <String> wynik = new ArrayList<String>();
        List<Grupy> grupys= grupyRepository.findAll();
        for(Grupy grupy : grupys){
            wynik.add(grupy.getNazwa());
        }
        return wynik;
    }

    @Override
    public void addGrupy(String nazwa, Long id) {
        Grupy nowyGrupy = new Grupy();
        nowyGrupy.setId(id);
        nowyGrupy.setNazwa(nazwa);
        grupyRepository.save(nowyGrupy);
    }
}
