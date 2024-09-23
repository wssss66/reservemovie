package reservemovie.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import reservemovie.domain.*;
import reservemovie.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class Decreasedseat extends AbstractEvent {

    private Long id;
    private String movieid;
    private String seatnum;
    private String userid;
    private Boolean reserveYn;

    public Decreasedseat(Managemovie aggregate) {
        super(aggregate);
    }

    public Decreasedseat() {
        super();
    }
}
//>>> DDD / Domain Event
