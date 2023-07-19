package tien.baseproject.orderservice.service;

import tien.baseproject.orderservice.dto.kafka.MailMessageDTO;
import tien.baseproject.orderservice.dto.request.OrderRequest;
import tien.baseproject.orderservice.entity.Order;

public interface MailService {
    void sendOrderEmail(String email, Order order, OrderRequest orderRequest);
}
