package pl.kz.service;

import java.util.List;
/**
 * Created by JACZAW on 29.05.2018.
 */
public interface KrajServices {

        public List<String> getAllKraje(long Id);
        public void addKraj(String nazwa, Long id);
}
