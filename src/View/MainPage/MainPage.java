package View.MainPage;

import Controller.MainPageController;
import Model.Auth.Authentication;
import View.Pesanan.Pesanan;
import View.Profile.Profile;
import java.sql.*;
import JDBC.sqlconnection;

import javax.swing.*;

public class MainPage extends javax.swing.JFrame {
    private MainPageController mainPageController;
    private javax.swing.JButton checkStatusButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton pesananButton;
    private javax.swing.JButton profileButton;



    public MainPage() {
        initComponents();
        mainPageController = new MainPageController(this);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        profileButton = new javax.swing.JButton();
        pesananButton = new javax.swing.JButton();
        checkStatusButton = new javax.swing.JButton(); // Tombol baru untuk cek status pesanan

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Welcome To Sendit");

        profileButton.setText("Profile");
        profileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileButtonActionPerformed(evt);
            }
        });

        pesananButton.setText("Buat Pesanan");
        pesananButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesananButtonActionPerformed(evt);
            }
        });

        checkStatusButton.setText("Cek Status Pesanan");
        checkStatusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkStatusButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(146, 146, 146)
                                .addComponent(jLabel1)
                                .addContainerGap(152, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(158, 158, 158)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(profileButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(pesananButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(checkStatusButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)) // Tombol "Cek Status Pesanan" ditambahkan di sini
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(profileButton)
                                .addGap(18, 18, 18)
                                .addComponent(pesananButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(checkStatusButton) // Tombol "Cek Status Pesanan" ditambahkan di sini
                                .addContainerGap(160, Short.MAX_VALUE))
        );

        pack();
    }

    private void profileButtonActionPerformed(java.awt.event.ActionEvent evt) {
        mainPageController.goToProfile(evt);
    }

    private void pesananButtonActionPerformed(java.awt.event.ActionEvent evt) {
        mainPageController.goToPesanan(evt);
    }

    private void checkStatusButtonActionPerformed(java.awt.event.ActionEvent evt) {
        mainPageController.checkStatus(evt);
    }


    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainPage().setVisible(true);
            }
        });
    }
}
