package reservemovie.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;
import reservemovie.infra.AbstractEvent;

@Data
public class Decreasedpoint extends AbstractEvent {

    private Long id;
    private String userid;
    private String point;
}
