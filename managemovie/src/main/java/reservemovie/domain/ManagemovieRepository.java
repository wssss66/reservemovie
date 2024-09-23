package reservemovie.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import reservemovie.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "managemovies",
    path = "managemovies"
)
public interface ManagemovieRepository
    extends PagingAndSortingRepository<Managemovie, Long> {}
