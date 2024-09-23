package reservemovie.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import reservemovie.domain.*;

@Component
public class ManagemovieHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Managemovie>> {

    @Override
    public EntityModel<Managemovie> process(EntityModel<Managemovie> model) {
        return model;
    }
}
