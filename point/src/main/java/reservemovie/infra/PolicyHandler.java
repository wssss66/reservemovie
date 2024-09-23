package reservemovie.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import reservemovie.config.kafka.KafkaProcessor;
import reservemovie.domain.*;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    PointRepository pointRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Decreasedseat'"
    )
    public void wheneverDecreasedseat_Decreaseseat(
        @Payload Decreasedseat decreasedseat
    ) {
        Decreasedseat event = decreasedseat;
        System.out.println(
            "\n\n##### listener Decreaseseat : " + decreasedseat + "\n\n"
        );

        // Sample Logic //
        Point.decreaseseat(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Increasedseat'"
    )
    public void wheneverIncreasedseat_Increseseat(
        @Payload Increasedseat increasedseat
    ) {
        Increasedseat event = increasedseat;
        System.out.println(
            "\n\n##### listener Increseseat : " + increasedseat + "\n\n"
        );

        // Sample Logic //
        Point.increseseat(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
