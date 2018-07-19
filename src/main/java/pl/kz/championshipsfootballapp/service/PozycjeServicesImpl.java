package pl.kz.championshipsfootballapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kz.championshipsfootballapp.model.Pozycje;
import pl.kz.championshipsfootballapp.repo.PozycjeRepository;

/**
 * Created by JACZAW on 29.05.2018.
 */
@Service
public class PozycjeServicesImpl implements PozycjeServices {


    @Autowired
    private PozycjeRepository pozycjeRepository;

    @Override
    public List<String> getAllPozycje(long id) {
        List <String> wynik = new ArrayList<String>();
        List<Pozycje> pozycjes= pozycjeRepository.findAll();
        for(Pozycje pozycje : pozycjes){
            wynik.add(pozycje.getNazwa());
        }
        return wynik;
    }

    @Override
    public void addPozycje(String nazwa, Long id) {
        Pozycje nowypozycje = new Pozycje();
        nowypozycje.setId(id);
        nowypozycje.setNazwa(nazwa);
        pozycjeRepository.save(nowypozycje);
    }
}
