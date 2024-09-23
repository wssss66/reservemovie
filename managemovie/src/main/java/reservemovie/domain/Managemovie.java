package reservemovie.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import reservemovie.ManagemovieApplication;
import reservemovie.domain.Decreasedseat;
import reservemovie.domain.Increasedseat;
import reservemovie.domain.Rejectedreservation;

@Entity
@Table(name = "Managemovie_table")
@Data
//<<< DDD / Aggregate Root
public class Managemovie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String movieid;

    private String seatnum;

    private String userid;

    private Boolean reserveYn;

    


    @PostPersist
    public void onPostPersist() {
        Decreasedseat decreasedseat = new Decreasedseat(this);
        decreasedseat.publishAfterCommit();

        Increasedseat increasedseat = new Increasedseat(this);
        increasedseat.publishAfterCommit();

        Rejectedreservation rejectedreservation = new Rejectedreservation(this);
        rejectedreservation.publishAfterCommit();
    }

    public static ManagemovieRepository repository() {
        ManagemovieRepository managemovieRepository = ManagemovieApplication.applicationContext.getBean(
            ManagemovieRepository.class
        );
        return managemovieRepository;
    }

    //<<< Clean Arch / Port Method
    public static void reservemovie(Reservedmovie reservedmovie) {

         repository().findById(Long.valueOf(reservedmovie.getId())).ifPresent(managemovie->{
        
            managemovie.setSeatnum(reservedmovie.getSeatnum());
            managemovie.setReserveYn(true);
            managemovie.setUserid(reservedmovie.getUserid());
            repository().save(managemovie);

         });
      

        //implement business logic here:

        /** Example 1:  new item 
        Managemovie managemovie = new Managemovie();
        repository().save(managemovie);

        Decreasedseat decreasedseat = new Decreasedseat(managemovie);
        decreasedseat.publishAfterCommit();
        Rejectedreservation rejectedreservation = new Rejectedreservation(managemovie);
        rejectedreservation.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(reservedmovie.get???()).ifPresent(managemovie->{
            
            managemovie // do something
            repository().save(managemovie);

            Decreasedseat decreasedseat = new Decreasedseat(managemovie);
            decreasedseat.publishAfterCommit();
            Rejectedreservation rejectedreservation = new Rejectedreservation(managemovie);
            rejectedreservation.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void cancelmovie(Canceledreservaion canceledreservaion) {
        //implement business logic here:

        repository().findById(canceledreservaion.getId()).ifPresent(managemovie->{
        managemovie.setReserveYn(false);
        managemovie.setUserid(null);
        managemovie.setSeatnum(null);
        repository().save(managemovie);
        });
        
        /** Example 1:  new item 
        Managemovie managemovie = new Managemovie();
        repository().save(managemovie);

        Increasedseat increasedseat = new Increasedseat(managemovie);
        increasedseat.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(canceledreservaion.get???()).ifPresent(managemovie->{
            
            managemovie // do something
            repository().save(managemovie);

            Increasedseat increasedseat = new Increasedseat(managemovie);
            increasedseat.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
