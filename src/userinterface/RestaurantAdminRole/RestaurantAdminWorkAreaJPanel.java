

package userinterface.RestaurantAdminRole;


import Business.CityNetwork;
import Business.EcoSystem;
import Business.Restaurant.Restaurant;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author  raunak
 */
public class RestaurantAdminWorkAreaJPanel extends javax.swing.JPanel {
    
    JPanel userProcessContainer;
    EcoSystem ecoSystem;
    UserAccount userAccount;
    Restaurant restaurant;
    CityNetwork cityNetwork;
    
    /** Creates new form AdminWorkAreaJPanel */
    public RestaurantAdminWorkAreaJPanel(JPanel userProcessContainer, EcoSystem ecoSystem, UserAccount userLogged,
        Restaurant restaurant, CityNetwork cityNetwork) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.ecoSystem = ecoSystem;
        this.userAccount = userLogged;
        this.restaurant = restaurant;
        this.cityNetwork = cityNetwork;
        valueLabel.setText(restaurant.getRestaurantName());
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        manageRestaurantInfoJButton = new javax.swing.JButton();
        manageMenuItemJButton = new javax.swing.JButton();
        manageOrdersJButton = new javax.swing.JButton();
        enterpriseLabel = new javax.swing.JLabel();
        valueLabel = new javax.swing.JLabel();

        setBackground(java.awt.Color.cyan);
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Manage Restaurant");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 380, -1));

        manageRestaurantInfoJButton.setText("Manage Restaurant Info");
        manageRestaurantInfoJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageRestaurantInfoJButtonActionPerformed(evt);
            }
        });
        add(manageRestaurantInfoJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 320, 180, -1));

        manageMenuItemJButton.setText("Manage menu");
        manageMenuItemJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageMenuItemJButtonActionPerformed(evt);
            }
        });
        add(manageMenuItemJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 260, 180, -1));

        manageOrdersJButton.setText("Manage Orders");
        manageOrdersJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageOrdersJButtonActionPerformed(evt);
            }
        });
        add(manageOrdersJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 200, 180, -1));

        enterpriseLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        enterpriseLabel.setText("Restaurant :");
        add(enterpriseLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 120, 30));

        valueLabel.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        valueLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        valueLabel.setText("<value>");
        add(valueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, 170, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void manageRestaurantInfoJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageRestaurantInfoJButtonActionPerformed
        // TODO add your handling code here:
        CardLayout cardLayout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("UpdateRestaurantInfo", new UpdateRestaurantInfoJPanel(userProcessContainer, restaurant,userAccount));
        cardLayout.next(userProcessContainer);
    }//GEN-LAST:event_manageRestaurantInfoJButtonActionPerformed

    private void manageMenuItemJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageMenuItemJButtonActionPerformed

        CardLayout cardLayout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("ManageMenuItems",new ManageMenuItemJPanel(userProcessContainer, userAccount, restaurant));
        cardLayout.next(userProcessContainer);
    }//GEN-LAST:event_manageMenuItemJButtonActionPerformed

    private void manageOrdersJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageOrdersJButtonActionPerformed
        
        CardLayout cardLayout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("ManageOrdersPanel", new ManageOrdersRestaurantJPanel(userProcessContainer, userAccount, restaurant,
            ecoSystem, cityNetwork));
        cardLayout.next(userProcessContainer);
    }//GEN-LAST:event_manageOrdersJButtonActionPerformed
    
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton manageMenuItemJButton;
    private javax.swing.JButton manageOrdersJButton;
    private javax.swing.JButton manageRestaurantInfoJButton;
    private javax.swing.JLabel valueLabel;
    // End of variables declaration//GEN-END:variables
    
}
