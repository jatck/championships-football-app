package pl.kz.championshipsfootballapp.repo;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.kz.championshipsfootballapp.model.Kluby;

/**
 * Created by JACZAW on 29.05.2018.
 */


    @Repository
    public interface KlubyRepository extends CrudRepository<Kluby, Long> {

        public abstract List<Kluby> findById(long id);
        public abstract List<Kluby> findAll();
    }


