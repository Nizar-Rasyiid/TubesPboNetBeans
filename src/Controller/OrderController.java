package Controller;

import Model.Pesanan.OrderService;

import java.util.List;

public class OrderController {
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    public void updateOrderStatus(String orderId, String newStatus) {
        try {
            orderService.updateOrderStatus(orderId, newStatus);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String> getOrders() {
        try {
            return orderService.getOrders();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
