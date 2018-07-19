package pl.kz.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.kz.model.Kraje;

/**
 * Created by JACZAW on 29.05.2018.
 */


    @Repository
    public interface KrajeRepository extends CrudRepository<Kraje, Long> {

        public abstract List<Kraje> findById(long id);
        public abstract List<Kraje> findAll();
    }


