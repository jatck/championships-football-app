package pl.kz.championshipsfootballapp.service;

import java.util.List;
/**
 * Created by JACZAW on 29.05.2018.
 */
public interface KlubyServices {

        public List<String> getAllKluby(long Id);
        public void addKluby(String nazwa, Long id);
}