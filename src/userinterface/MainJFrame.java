/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import Business.CityNetwork;
import Business.Customer.Customer;
import Business.EcoSystem;
import Business.DB4OUtil.DB4OUtil;
import Business.Employee.RestaurantEmployee;
import Business.JpanelManager;
import Business.Restaurant.Restaurant;
import Business.SysAdmin.SysAdmin;
import Business.SysAdmin.SysAdminDirectory;
import Business.UserAccount.UserAccount;

import java.awt.CardLayout;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author manojreddy
 */
public class MainJFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainJFrame
     */
    private EcoSystem system;
    private DB4OUtil dB4OUtil = DB4OUtil.getInstance();

    public MainJFrame() {
        initComponents();
        system = dB4OUtil.retrieveSystem();
        this.setSize(1680, 1050);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        controljPanel = new javax.swing.JPanel();
        loginJButton = new javax.swing.JButton();
        userNameJTextField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        userNamejLabel = new javax.swing.JLabel();
        passwordjLabel = new javax.swing.JLabel();
        loginJLabel = new javax.swing.JLabel();
        logoutJButton = new javax.swing.JButton();
        container = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        controljPanel.setBackground(new java.awt.Color(51, 153, 255));

        loginJButton.setText("Login");
        loginJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginJButtonActionPerformed(evt);
            }
        });

        userNamejLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        userNamejLabel.setText("User Name");

        passwordjLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        passwordjLabel.setText("Password");

        logoutJButton.setText("Logout");
        logoutJButton.setEnabled(false);
        logoutJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout controljPanelLayout = new javax.swing.GroupLayout(controljPanel);
        controljPanel.setLayout(controljPanelLayout);
        controljPanelLayout.setHorizontalGroup(
            controljPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controljPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(controljPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(controljPanelLayout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(loginJLabel))
                    .addGroup(controljPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(controljPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(loginJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(logoutJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.CENTER, controljPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwordjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.CENTER, controljPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(userNameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(userNamejLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        controljPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {loginJButton, logoutJButton});

        controljPanelLayout.setVerticalGroup(
            controljPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controljPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(userNamejLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(userNameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(passwordjLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(loginJButton)
                .addGap(28, 28, 28)
                .addComponent(logoutJButton)
                .addGap(12, 12, 12)
                .addComponent(loginJLabel)
                .addContainerGap(172, Short.MAX_VALUE))
        );

        jSplitPane1.setLeftComponent(controljPanel);

        container.setLayout(new java.awt.CardLayout());
        jSplitPane1.setRightComponent(container);

        getContentPane().add(jSplitPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginJButtonActionPerformed
        // Get user name
        
        String userName = userNameJTextField.getText();
        char[] passwordCharArray = passwordField.getPassword();
        String password = String.valueOf(passwordCharArray);
        
        UserAccount userLogged = null;
        
        // System Admin Login flow
        
        if(!system.getSysAdminDirectory().getSysAdmins().isEmpty()){
            
            userLogged = system.getSysAdminDirectory().isUserSysAdmin(userName, password);
            if(userLogged!=null){
                
                CardLayout layout=(CardLayout)container.getLayout();
                container.add("adminMainPanel", JpanelManager.getMasterPanel(container,system,userLogged));
                layout.next(container);
                clearLoginPanels();
                return ;
            }
        }
        
        // Restaurant Manager flow 
        
        if(userLogged==null) {
            
            if(!system.getCityNetworks().isEmpty()){
                for(CityNetwork cityNetwork:system.getCityNetworks()){
                    
                    if(!cityNetwork.getRestaurantDirectory().getRestaurants().isEmpty()){
                        
                        for(Restaurant restaurant:cityNetwork.getRestaurantDirectory().getRestaurants()){
                            
                            for(RestaurantEmployee restaurantEmployee:restaurant.getRestaurantEmployeeDirectory().getEmployeeList()){
                                
                                if(restaurantEmployee.getUserName().equals(userName) && restaurantEmployee.getPassword().equals(password)){
                                    userLogged = restaurantEmployee;
                                    CardLayout layout=(CardLayout)container.getLayout();
                                    container.add("restaurantMainPanel", JpanelManager.getRestaurantManagerPanel(container,system,userLogged,restaurant,cityNetwork));
                                    layout.next(container);
                                    clearLoginPanels();
                                    return ;
                                }
                                
                            }
                            
                        }
                    }
                    
                }
            }
            
        }
        
        // Customer login Flow
        if(userLogged==null){
            
            if(!system.getCustomerDirectory().getCustomers().isEmpty()){
                
                for(Customer customer:system.getCustomerDirectory().getCustomers()){
                    if(customer.getUserName().equals(userName) && customer.getPassword().equals(password)){
                        userLogged = customer;
                        CardLayout layout = (CardLayout) container.getLayout();
                        container.add("CustomerMainPanel",JpanelManager.getCustomerMainPanel(container, system, userLogged));
                    }
                }
            }
        }
        
        // Delivery Person flow
        if(userLogged == null) {
            
        }
        
        if(userLogged == null){
            JOptionPane.showMessageDialog(this, "Please recheck the Credentials once again");
        }
    }//GEN-LAST:event_loginJButtonActionPerformed

    private void clearLoginPanels() {
        
        userNameJTextField.setText("");
        userNameJTextField.setEnabled(false);
        passwordField.setText("");
        passwordField.setEnabled(false);
        loginJButton.setEnabled(false);
        logoutJButton.setEnabled(true);
        
    }
    
    private void logoutJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutJButtonActionPerformed
        logoutJButton.setEnabled(false);
        userNameJTextField.setEnabled(true);
        passwordField.setEnabled(true);
        loginJButton.setEnabled(true);

        userNameJTextField.setText("");
        passwordField.setText("");

        container.removeAll();
        JPanel blankJP = new JPanel();
        container.add("blank", blankJP);
        CardLayout crdLyt = (CardLayout) container.getLayout();
        crdLyt.next(container);
        dB4OUtil.storeSystem(system);
    }//GEN-LAST:event_logoutJButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel container;
    private javax.swing.JPanel controljPanel;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JButton loginJButton;
    private javax.swing.JLabel loginJLabel;
    private javax.swing.JButton logoutJButton;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordjLabel;
    private javax.swing.JTextField userNameJTextField;
    private javax.swing.JLabel userNamejLabel;
    // End of variables declaration//GEN-END:variables
}
