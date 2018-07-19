package pl.kz.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kz.model.Kraje;
import pl.kz.repository.KrajeRepository;

/**
 * Created by JACZAW on 29.05.2018.
 */
@Service
public class KrajServicesImpl implements KrajServices {


    @Autowired
    private KrajeRepository krajeRepository;

    @Override
    public List<String> getAllKraje(long id) {
        List <String> wynik = new ArrayList<String>();
        List<Kraje> krajes= krajeRepository.findAll();
        for(Kraje kraje : krajes){
            wynik.add(kraje.getNazwa());
        }
        return wynik;
    }

    @Override
    public void addKraj(String nazwa, Long id) {
        Kraje nowyKraje = new Kraje();
        nowyKraje.setId(id);
        nowyKraje.setNazwa(nazwa);
        krajeRepository.save(nowyKraje);
    }
}
