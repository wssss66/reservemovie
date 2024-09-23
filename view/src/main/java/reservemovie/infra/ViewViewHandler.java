package reservemovie.infra;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import reservemovie.config.kafka.KafkaProcessor;
import reservemovie.domain.*;

@Service
public class ViewViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private ViewRepository viewRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenIncreasedpoint_then_UPDATE_1(
        @Payload Increasedpoint increasedpoint
    ) {
        try {
            if (!increasedpoint.validate()) return;
            // view 객체 조회

            List<View> viewList = viewRepository.findByUserid(
                increasedpoint.getUserid()
            );
            for (View view : viewList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                view.setPoint(increasedpoint.getPoint());
                // view 레파지 토리에 save
                viewRepository.save(view);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenDecreasedpoint_then_UPDATE_2(
        @Payload Decreasedpoint decreasedpoint
    ) {
        try {
            if (!decreasedpoint.validate()) return;
            // view 객체 조회

            List<View> viewList = viewRepository.findByUserid(
                decreasedpoint.getUserid()
            );
            for (View view : viewList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                view.setPoint(decreasedpoint.getPoint());
                // view 레파지 토리에 save
                viewRepository.save(view);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
