package tien.baseproject.orderservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tien.baseproject.orderservice.dto.request.OrderRequest;
import tien.baseproject.orderservice.service.OrderService;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public String placeOrder(HttpServletRequest request, @RequestBody OrderRequest orderRequest){
        orderService.placeOrder(request, orderRequest);
        return "Order Placed Successfully";
    }

}
