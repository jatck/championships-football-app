package pl.kz.championshipsfootballapp.repo;

/**
 * Created by JACZAW on 20.07.2018.
 */

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pl.kz.championshipsfootballapp.model.Grupy;

@RepositoryRestResource(collectionResourceRel = "grupy", path = "grupy")
public interface GrupyRestRepository extends PagingAndSortingRepository<Grupy, Long> {

    List<Grupy> findByNazwa(@Param("nazwa") String nazwa);

}
