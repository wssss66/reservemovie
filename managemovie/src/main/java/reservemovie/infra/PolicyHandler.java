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
    ManagemovieRepository managemovieRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Reservedmovie'"
    )
    public void wheneverReservedmovie_Reservemovie(
        @Payload Reservedmovie reservedmovie
    ) {
        Reservedmovie event = reservedmovie;
        System.out.println(
            "\n\n##### listener Reservemovie : " + reservedmovie + "\n\n"
        );

        // Sample Logic //
        Managemovie.reservemovie(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Canceledreservaion'"
    )
    public void wheneverCanceledreservaion_Cancelmovie(
        @Payload Canceledreservaion canceledreservaion
    ) {
        Canceledreservaion event = canceledreservaion;
        System.out.println(
            "\n\n##### listener Cancelmovie : " + canceledreservaion + "\n\n"
        );

        // Sample Logic //
        Managemovie.cancelmovie(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
