package pl.kz.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kz.model.Kluby;
import pl.kz.repository.KlubyRepository;

/**
 * Created by JACZAW on 29.05.2018.
 */
@Service
public class KlubyServicesImpl implements KlubyServices {


    @Autowired
    private KlubyRepository klubyRepository;

    @Override
    public List<String> getAllKluby(long id) {
        List <String> wynik = new ArrayList<String>();
        List<Kluby> klubys= klubyRepository.findAll();
        for(Kluby kluby : klubys){
            wynik.add(kluby.getNazwa());
        }
        return wynik;
    }

    @Override
    public void addKluby(String nazwa, Long id) {
        Kluby nowyKluby = new Kluby();
        nowyKluby.setId(id);
        nowyKluby.setNazwa(nazwa);
        klubyRepository.save(nowyKluby);
    }
}
