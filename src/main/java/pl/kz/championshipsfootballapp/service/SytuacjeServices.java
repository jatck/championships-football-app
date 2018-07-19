package pl.kz.championshipsfootballapp.service;

import java.util.List;
/**
 * Created by JACZAW on 29.05.2018.
 */
public interface SytuacjeServices {

        public List<String> getAllSytuacje(long Id);
        public void addSytuacje(String nazwa, Long id);
}
