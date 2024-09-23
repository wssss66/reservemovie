package reservemovie.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import reservemovie.domain.*;
import reservemovie.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class Decreasedpoint extends AbstractEvent {

    private Long id;
    private String userid;
    private String point;

    public Decreasedpoint(Point aggregate) {
        super(aggregate);
    }

    public Decreasedpoint() {
        super();
    }
}
//>>> DDD / Domain Event
