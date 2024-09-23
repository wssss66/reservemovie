package reservemovie.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import reservemovie.domain.*;
import reservemovie.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class Canceledreservaion extends AbstractEvent {

    private Long id;
    private String userid;
    private String movieid;
    private Date reservedt;
    private String seatnum;
    private String username;
    private String moviename;
    private Date movietime;

    public Canceledreservaion(Reservation aggregate) {
        super(aggregate);
    }

    public Canceledreservaion() {
        super();
    }
}
//>>> DDD / Domain Event
