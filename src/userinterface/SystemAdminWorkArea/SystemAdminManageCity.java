/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.SystemAdminWorkArea;

import Business.CityNetwork;
import Business.EcoSystem;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author manojreddy
 */
public class SystemAdminManageCity extends javax.swing.JPanel {

    /**
     * Creates new form SystemAdminManageCity
     */
    
    JPanel userProcessContainer;
    EcoSystem ecosystem;
    CityNetwork cityNetwork;
    UserAccount userLogged;
    
    public SystemAdminManageCity(JPanel userProcessContainer,EcoSystem ecosystem,CityNetwork cityNetwork,UserAccount userLogged) {
        this.userProcessContainer = userProcessContainer;
        this.ecosystem = ecosystem;
        this.cityNetwork = cityNetwork;
        this.userLogged = userLogged;
        initComponents();
        updateLabel();
    }
    
    private void updateLabel(){
        headerjLabel.setText(headerjLabel.getText()+cityNetwork.getCityName().name());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backjButton = new javax.swing.JButton();
        headerjLabel = new javax.swing.JLabel();
        manageRestaurantjButton = new javax.swing.JButton();
        manageCustomersjButton = new javax.swing.JButton();
        manageDeliveryPersonsjButton = new javax.swing.JButton();

        backjButton.setText("< < Back");
        backjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButtonActionPerformed(evt);
            }
        });

        headerjLabel.setFont(new java.awt.Font("Lucida Grande", 3, 18)); // NOI18N
        headerjLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerjLabel.setText("Manage Data in the city : ");

        manageRestaurantjButton.setText("Manage Restaurants >");

        manageCustomersjButton.setText("Manage Customers >");
        manageCustomersjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageCustomersjButtonActionPerformed(evt);
            }
        });

        manageDeliveryPersonsjButton.setText("Manage DeliveryPersons >");
        manageDeliveryPersonsjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageDeliveryPersonsjButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(backjButton)
                        .addGap(74, 74, 74)
                        .addComponent(headerjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(271, 271, 271)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(manageRestaurantjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(manageCustomersjButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(manageDeliveryPersonsjButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(155, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {manageCustomersjButton, manageDeliveryPersonsjButton, manageRestaurantjButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(headerjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backjButton))
                .addGap(90, 90, 90)
                .addComponent(manageRestaurantjButton)
                .addGap(18, 18, 18)
                .addComponent(manageCustomersjButton)
                .addGap(18, 18, 18)
                .addComponent(manageDeliveryPersonsjButton)
                .addContainerGap(137, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButtonActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout cardLayout = (CardLayout) userProcessContainer.getLayout();
        cardLayout.previous(userProcessContainer);
    }//GEN-LAST:event_backjButtonActionPerformed

    private void manageCustomersjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageCustomersjButtonActionPerformed
        // TODO add your handling code here:
        
        CardLayout cardLayout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("adminCustomerManagePanel", new ManageCustomerJpanel(userProcessContainer, userLogged, ecosystem));
        cardLayout.next(userProcessContainer);
    }//GEN-LAST:event_manageCustomersjButtonActionPerformed

    private void manageDeliveryPersonsjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageDeliveryPersonsjButtonActionPerformed
        // TODO add your handling code here:
        CardLayout cardLayout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("adminDeliveryPersonManagePanel", new ManageDeliveryPersonsJPanel(userProcessContainer, userLogged, ecosystem, cityNetwork));
        cardLayout.next(userProcessContainer);
    }//GEN-LAST:event_manageDeliveryPersonsjButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backjButton;
    private javax.swing.JLabel headerjLabel;
    private javax.swing.JButton manageCustomersjButton;
    private javax.swing.JButton manageDeliveryPersonsjButton;
    private javax.swing.JButton manageRestaurantjButton;
    // End of variables declaration//GEN-END:variables
}
