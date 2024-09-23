package reservemovie.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import reservemovie.domain.*;
import reservemovie.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class Rejectedreservation extends AbstractEvent {

    private Long id;
    private String movieid;
    private String seatnum;
    private String userid;
    private Boolean reserveYn;

    public Rejectedreservation(Managemovie aggregate) {
        super(aggregate);
    }

    public Rejectedreservation() {
        super();
    }
}
//>>> DDD / Domain Event
