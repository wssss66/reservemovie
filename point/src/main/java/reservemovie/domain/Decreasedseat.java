package reservemovie.domain;

import java.util.*;
import lombok.*;
import reservemovie.domain.*;
import reservemovie.infra.AbstractEvent;

@Data
@ToString
public class Decreasedseat extends AbstractEvent {

    private Long id;
    private String movieid;
    private String seatnum;
    private String userid;
    private Boolean reserveYn;
}
