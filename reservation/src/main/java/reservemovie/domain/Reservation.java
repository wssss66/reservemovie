package reservemovie.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import reservemovie.ReservationApplication;
import reservemovie.domain.Canceledreservaion;
import reservemovie.domain.Reservedmovie;

@Entity
@Table(name = "Reservation_table")
@Data
//<<< DDD / Aggregate Root
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userid;

    private String movieid;

    private Date reservedt;

    private String seatnum;

    private String username;

    private String moviename;

    private Date movietime;

    @PostPersist
    public void onPostPersist() {
        Reservedmovie reservedmovie = new Reservedmovie(this);
        reservedmovie.publishAfterCommit();

        Canceledreservaion canceledreservaion = new Canceledreservaion(this);
        canceledreservaion.publishAfterCommit();
    }

    public static ReservationRepository repository() {
        ReservationRepository reservationRepository = ReservationApplication.applicationContext.getBean(
            ReservationRepository.class
        );
        return reservationRepository;
    }

    public void reservemovie() {
        //implement business logic here:

        Reservedmovie reservedmovie = new Reservedmovie(this);
        reservedmovie.publishAfterCommit();
    }

    public void cancelmovie() {
        //implement business logic here:

        Canceledreservaion canceledreservaion = new Canceledreservaion(this);
        canceledreservaion.publishAfterCommit();
    }
}
//>>> DDD / Aggregate Root
