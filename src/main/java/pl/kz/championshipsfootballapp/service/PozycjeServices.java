package pl.kz.championshipsfootballapp.service;

import java.util.List;
/**
 * Created by JACZAW on 29.05.2018.
 */
public interface PozycjeServices {

        public List<String> getAllPozycje(long Id);
        public void addPozycje(String nazwa, Long id);
}
