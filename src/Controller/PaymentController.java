package Controller;

import Model.Payment.*;
import Model.Pesanan.PesananModel;
import View.MainPage.MainPage;
import View.Payment.Payment;
import javax.swing.*;
import java.awt.event.ActionEvent;

public class PaymentController {
    private Payment view;
    private PesananModel pesananModel;
    private PaymentMethod paymentMethod;

    public PaymentController(Payment view, PesananModel pesananModel) {
        this.view = view;
        this.pesananModel = pesananModel;
    }

    public void ewalletBtnActionPerformed(ActionEvent evt) {
        paymentMethod = new EWalletPayment(view.getIdUser(), view.getHarga(), view.getIdPemesanan());
    }

    public void bankBtnActionPerformed(ActionEvent evt) {
        paymentMethod = new BankPayment(view.getIdUser(), view.getHarga(), view.getIdPemesanan());
    }

    public void cashBtnActionPerformed(ActionEvent evt) {
        paymentMethod = new CashPayment(view.getIdUser(), view.getHarga(), view.getIdPemesanan());
    }

    public void bayarBtnActionPerformed(ActionEvent evt) {
        if (paymentMethod == null) {
            JOptionPane.showMessageDialog(view, "Silakan pilih metode pembayaran", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        paymentMethod.processPayment();
        JOptionPane.showMessageDialog(view, "Pembayaran berhasil!");
        MainPage mp = new MainPage();
        mp.setVisible(true);
        view.dispose(); // Close the payment window
    }
}
