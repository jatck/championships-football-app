package pl.kz.championshipsfootballapp.repo;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.kz.championshipsfootballapp.model.Sytuacje;

/**
 * Created by JACZAW on 29.05.2018.
 */


    @Repository
    public interface SytuacjeRepository extends CrudRepository<Sytuacje, Long> {

        public abstract List<Sytuacje> findById(long id);
        public abstract List<Sytuacje> findAll();
    }


