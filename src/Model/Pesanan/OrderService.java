package Model.Pesanan;

import java.util.List;

public interface OrderService {
    void updateOrderStatus(String orderId, String newStatus) throws Exception;
    List<String> getOrders() throws Exception; // Atau Anda dapat menggunakan tipe data yang lebih kompleks untuk menyimpan detail pesanan
}
