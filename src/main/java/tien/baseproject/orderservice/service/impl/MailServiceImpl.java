package tien.baseproject.orderservice.service.impl;

import com.sun.istack.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.multipart.MultipartFile;
import tien.baseproject.orderservice.constant.MailAttachmentDTO;
import tien.baseproject.orderservice.constant.MailConstant;
import tien.baseproject.orderservice.dto.kafka.MailMessageDTO;
import tien.baseproject.orderservice.dto.request.OrderRequest;
import tien.baseproject.orderservice.entity.Order;
import tien.baseproject.orderservice.service.MailService;
import org.springframework.beans.factory.annotation.Value;
import tien.baseproject.orderservice.utils.MailUtils;
import java.text.MessageFormat;
import java.util.Collections;
import java.util.HashMap;

@Service
@Log4j2
@RequiredArgsConstructor
public class MailServiceImpl implements MailService {
    private final KafkaTemplate<String, MailMessageDTO> emailKafkaTemplate;

    @Value(value = "${kafka.email-topic}")
    private String topicNameEmail;

    @Override
    public void sendOrderEmail(String email, Order order, OrderRequest orderRequest){
        try{
            HashMap<String, Object> variables = new HashMap<>();
            variables.put("order_id", order.getId());
            variables.put("list_order_request", orderRequest.getOrderLineItemsDtoList());

            MailMessageDTO mailMessageDTO = MailUtils.buildMailDTO(
                    Collections.singletonList(email),
                    MailConstant.Template.CREATE_ORDER.getTemplateName(),
                    variables, MailConstant.Template.CREATE_ORDER.getSubject());

            this.sendEmailToKafkaQueue(mailMessageDTO);
        }catch (Exception e){

        }
    }

    public void sendEmailToQueue(MailMessageDTO mailDTO) {
        try {
            sendEmailToKafkaQueue(mailDTO);
        } catch (Exception exception) {
            log.info(exception.getMessage());
        }
    }

    private void sendEmailToKafkaQueue(MailMessageDTO messageDTO) {
        log.info("Send email to Kafka topic: {} - [{}]", topicNameEmail, messageDTO);

        ListenableFuture<SendResult<String, MailMessageDTO>> future = emailKafkaTemplate.send(topicNameEmail, messageDTO);

        future.addCallback(new ListenableFutureCallback<SendResult<String, MailMessageDTO>>() {
            @Override
            public void onSuccess(SendResult<String, MailMessageDTO> result) {
                log.info(MessageFormat.format("Sent message=[{0}] with offset=[{1}]", messageDTO.getTraceId(), result.getRecordMetadata().offset()));
            }

            @Override
            public void onFailure(@NotNull Throwable ex) {
                log.error(MessageFormat.format("Unable to send message=[] due to: {0}", ex.getCause().toString()), ex);
            }
        });
    }
}
