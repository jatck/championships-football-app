package pl.kz.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.kz.model.Pozycje;

/**
 * Created by JACZAW on 29.05.2018.
 */


    @Repository
    public interface PozycjeRepository extends CrudRepository<Pozycje, Long> {

        public abstract List<Pozycje> findById(long id);
        public abstract List<Pozycje> findAll();
    }


