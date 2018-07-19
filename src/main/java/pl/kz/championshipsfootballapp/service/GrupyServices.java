package pl.kz.championshipsfootballapp.service;

import java.util.List;
/**
 * Created by JACZAW on 29.05.2018.
 */
public interface GrupyServices {

        public List<String> getAllGrupy(long Id);
        public void addGrupy(String nazwa, Long id);
}
