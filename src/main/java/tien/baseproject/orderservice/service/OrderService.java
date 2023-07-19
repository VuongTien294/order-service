package tien.baseproject.orderservice.service;

import tien.baseproject.orderservice.dto.request.OrderRequest;

import javax.servlet.http.HttpServletRequest;

public interface OrderService {
    void placeOrder(HttpServletRequest request, OrderRequest orderRequest);
}
