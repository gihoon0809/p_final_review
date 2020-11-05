package pizzalgh;

import pizzalgh.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    @Autowired
    ReviewRepository reviewRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){

    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverDelivered_Requestreview(@Payload Delivered delivered){

        if(delivered.isMe()){
            System.out.println("##### listener Requestreview : " + delivered.toJson());

            Review review = new Review();
            review.setOrderedId(delivered.getOrderId());
            review.setReviewtext("review:test1");
            reviewRepository.save(review);
        }
    }

}
