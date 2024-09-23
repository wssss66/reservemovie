package reservemovie.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import reservemovie.PointApplication;
import reservemovie.domain.Decreasedpoint;
import reservemovie.domain.Increasedpoint;

@Entity
@Table(name = "Point_table")
@Data
//<<< DDD / Aggregate Root
public class Point {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userid;

    private String point;

    @PostPersist
    public void onPostPersist() {
        Increasedpoint increasedpoint = new Increasedpoint(this);
        increasedpoint.publishAfterCommit();

        Decreasedpoint decreasedpoint = new Decreasedpoint(this);
        decreasedpoint.publishAfterCommit();
    }

    public static PointRepository repository() {
        PointRepository pointRepository = PointApplication.applicationContext.getBean(
            PointRepository.class
        );
        return pointRepository;
    }

    //<<< Clean Arch / Port Method
    public static void decreaseseat(Decreasedseat decreasedseat) {
        //implement business logic here:

        /** Example 1:  new item 
        Point point = new Point();
        repository().save(point);

        Increasedpoint increasedpoint = new Increasedpoint(point);
        increasedpoint.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(decreasedseat.get???()).ifPresent(point->{
            
            point // do something
            repository().save(point);

            Increasedpoint increasedpoint = new Increasedpoint(point);
            increasedpoint.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void increseseat(Increasedseat increasedseat) {
        //implement business logic here:

        /** Example 1:  new item 
        Point point = new Point();
        repository().save(point);

        Decreasedpoint decreasedpoint = new Decreasedpoint(point);
        decreasedpoint.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(increasedseat.get???()).ifPresent(point->{
            
            point // do something
            repository().save(point);

            Decreasedpoint decreasedpoint = new Decreasedpoint(point);
            decreasedpoint.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
