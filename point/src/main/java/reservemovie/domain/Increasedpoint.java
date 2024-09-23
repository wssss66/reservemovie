package reservemovie.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import reservemovie.domain.*;
import reservemovie.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class Increasedpoint extends AbstractEvent {

    private Long id;
    private String userid;
    private String point;

    public Increasedpoint(Point aggregate) {
        super(aggregate);
    }

    public Increasedpoint() {
        super();
    }
}
//>>> DDD / Domain Event
