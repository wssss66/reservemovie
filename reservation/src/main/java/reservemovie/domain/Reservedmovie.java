package reservemovie.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import reservemovie.domain.*;
import reservemovie.infra.AbstractEvent;

//<<< DDD / Domain Event
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

    public Reservedmovie(Reservation aggregate) {
        super(aggregate);
    }

    public Reservedmovie() {
        super();
    }

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

    public Long Setid(Long id){
        return this.id;
    }

    public String Setuserid(String userid){
        return this.userid;
    }

    public String Setmovieid(String movieid){
        return this.movieid;
    }

    public String Setseatnum(String seatnum){
        return this.seatnum;
    }


}
//>>> DDD / Domain Event
