package pl.kz.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.kz.model.Grupy;

/**
 * Created by JACZAW on 29.05.2018.
 */


    @Repository
    public interface GrupyRepository extends CrudRepository<Grupy, Long> {

        public abstract List<Grupy> findById(long id);
        public abstract List<Grupy> findAll();
    }


