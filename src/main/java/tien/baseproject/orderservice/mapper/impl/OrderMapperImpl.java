package tien.baseproject.orderservice.mapper.impl;

import org.springframework.stereotype.Component;
import tien.baseproject.orderservice.dto.request.OrderLineItemsRequest;
import tien.baseproject.orderservice.entity.Order;
import tien.baseproject.orderservice.entity.OrderLineItems;
import tien.baseproject.orderservice.mapper.OrderMapper;

@Component
public class OrderMapperImpl implements OrderMapper {

    @Override
    public OrderLineItems mapToDto(OrderLineItemsRequest orderLineItemsDto, Order order) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        orderLineItems.setOrder(order);
        return orderLineItems;
    }
}
