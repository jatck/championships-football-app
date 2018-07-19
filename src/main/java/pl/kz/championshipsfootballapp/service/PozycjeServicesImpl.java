package pl.kz.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kz.model.pozycje;
import pl.kz.repository.pozycjeRepository;

/**
 * Created by JACZAW on 29.05.2018.
 */
@Service
public class pozycjeServicesImpl implements pozycjeServices {


    @Autowired
    private pozycjeRepository pozycjeRepository;

    @Override
    public List<String> getAllpozycje(long id) {
        List <String> wynik = new ArrayList<String>();
        List<pozycje> pozycjes= pozycjeRepository.findAll();
        for(pozycje pozycje : pozycjes){
            wynik.add(pozycje.getNazwa());
        }
        return wynik;
    }

    @Override
    public void addpozycje(String nazwa, Long id) {
        pozycje nowypozycje = new pozycje();
        nowypozycje.setId(id);
        nowypozycje.setNazwa(nazwa);
        pozycjeRepository.save(nowypozycje);
    }
}
