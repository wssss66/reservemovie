package reservemovie.infra;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import reservemovie.domain.*;

@RepositoryRestResource(collectionResourceRel = "views", path = "views")
public interface ViewRepository extends PagingAndSortingRepository<View, Long> {
    List<View> findByUserid(String userid);
}
