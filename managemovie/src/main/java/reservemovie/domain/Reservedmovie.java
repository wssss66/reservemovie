package reservemovie.domain;

import java.util.*;
import lombok.*;
import reservemovie.domain.*;
import reservemovie.infra.AbstractEvent;

@Data
@ToString
public class Reservedmovie extends AbstractEvent {

    private Long id;
    private String userid;
    private String movieid;
    private Date reservedt;
    private String seatnum;
    private String username;
    private String moviename;
    private Date movietime;

    public Long Getid(){
        return this.id;
    }

    public String Getuserid(){
        return this.userid;
    }

    public String Getmovieid(){
        return this.movieid;
    }

    public String Getseatnum(){
        return this.seatnum;
    }
}
