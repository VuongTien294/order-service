package tien.baseproject.orderservice.mapper;

import tien.baseproject.orderservice.dto.request.OrderLineItemsRequest;
import tien.baseproject.orderservice.entity.Order;
import tien.baseproject.orderservice.entity.OrderLineItems;

public interface OrderMapper {
    OrderLineItems mapToDto(OrderLineItemsRequest orderLineItemsDto, Order order);
}
