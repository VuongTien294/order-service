package tien.baseproject.orderservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import tien.baseproject.orderservice.dto.request.OrderLineItemsRequest;
import tien.baseproject.orderservice.dto.request.OrderRequest;
import tien.baseproject.orderservice.dto.response.InventoryResponse;
import tien.baseproject.orderservice.entity.Order;
import tien.baseproject.orderservice.entity.OrderLineItems;
import tien.baseproject.orderservice.mapper.OrderMapper;
import tien.baseproject.orderservice.repository.OrderLineItemRepository;
import tien.baseproject.orderservice.repository.OrderRepository;
import tien.baseproject.orderservice.service.MailService;
import tien.baseproject.orderservice.service.OrderService;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    @Value(value = "${url.check-quantity-inventory-url}")
    private String checkQuantityInventoryEndpoint;

    private final OrderMapper orderMapper;
    private final OrderRepository orderRepository;
    private final OrderLineItemRepository orderLineItemRepository;
    private final MailService mailService;

    private final RestTemplate restTemplate;

    @Override
    public void placeOrder(HttpServletRequest request, OrderRequest orderRequest){

        String userId = request.getHeader("user_id");
        String userEmail = request.getHeader("email");

        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        //check xem còn hàng không ?
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(checkQuantityInventoryEndpoint)
                .queryParam("skuCode", getListSkuCode(orderRequest));

        URI uri = builder.build().toUri();

        ParameterizedTypeReference<List<InventoryResponse>> responseType = new ParameterizedTypeReference<List<InventoryResponse>>() {};

        List<InventoryResponse> listInventoryResponse = restTemplate.exchange(uri, HttpMethod.GET, null, responseType).getBody();

        if(checkIsInstock(listInventoryResponse)){
            Order orderSave =  orderRepository.save(order);
            List<OrderLineItems> orderLineItems = new ArrayList<>();
            for (OrderLineItemsRequest element : orderRequest.getOrderLineItemsDtoList()) {
                orderLineItems.add(orderMapper.mapToDto(element, orderSave));
            }
            orderLineItemRepository.saveAll(orderLineItems);

            //Gửi mail cho người đang đăng nhập
            mailService.sendOrderEmail(userEmail, order, orderRequest);

        }else {
            throw new IllegalArgumentException("Product is not in stock, please try again later");
        }
    }

    private List<String> getListSkuCode(OrderRequest orderRequest){
        List<String> response = new ArrayList<>();
        for (OrderLineItemsRequest element: orderRequest.getOrderLineItemsDtoList()) {
            response.add(element.getSkuCode());
        }
        return response;
    }

    Boolean checkIsInstock(List<InventoryResponse> list){
        Boolean response = true;
        for (InventoryResponse element: list) {
            if(!element.isInStock()){
                response = false;
            }
        }
        return response;
    }

}
