package pl.kz.championshipsfootballapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kz.championshipsfootballapp.model.Sytuacje;
import pl.kz.championshipsfootballapp.repo.SytuacjeRepository;

/**
 * Created by JACZAW on 29.05.2018.
 */
@Service
public class SytuacjeServicesImpl implements SytuacjeServices {


    @Autowired
    private SytuacjeRepository sytuacjeRepository;

    @Override
    public List<String> getAllSytuacje(long id) {
        List <String> wynik = new ArrayList<String>();
        List<Sytuacje> sytuacjes= sytuacjeRepository.findAll();
        for(Sytuacje sytuacje : sytuacjes){
            wynik.add(sytuacje.getNazwa());
        }
        return wynik;
    }

    @Override
    public void addSytuacje(String nazwa, Long id) {
        Sytuacje nowySytuacje = new Sytuacje();
        nowySytuacje.setId(id);
        nowySytuacje.setNazwa(nazwa);
        sytuacjeRepository.save(nowySytuacje);
    }
}
