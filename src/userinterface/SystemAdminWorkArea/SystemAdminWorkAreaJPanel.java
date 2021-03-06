/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.SystemAdminWorkArea;

import Business.CityName;
import Business.CityNetwork;
import Business.EcoSystem;
import Business.SysAdmin.SysAdmin;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MyPC1
 */
public class SystemAdminWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form SystemAdminWorkAreaJPanel
     */
    JPanel userProcessContainer;
    EcoSystem ecosystem;
    UserAccount userLogged;
    public SystemAdminWorkAreaJPanel(JPanel userProcessContainer,EcoSystem ecosystem,UserAccount userLogged) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.ecosystem=ecosystem;
        this.userLogged=userLogged;
        populateCities();
        populateSysAdmins();
    }
    
    private void populateCities() {
        
        List<CityNetwork> cityNetworks = ecosystem.getCityNetworks();
        cityjComboBox.removeAllItems();
        for(CityNetwork cityNetwork:cityNetworks){
            cityjComboBox.addItem(cityNetwork.getCityName().name());
        }
        
        addCityjComboBox.removeAllItems();
        for(String cityName:CityName.getCitiesList()){
            addCityjComboBox.addItem(cityName);
        }
        addCityjComboBox.setSelectedIndex(addCityjComboBox.getItemCount()-1);
    }
    
    public void populateSysAdmins() {
        
        DefaultTableModel sysAdminsModel = (DefaultTableModel) sysAdminsjTable.getModel();
        sysAdminsModel.setRowCount(0);
        
        int sysAdminsCount=0;
        for(SysAdmin sysAdmin:ecosystem.getSysAdminDirectory().getSysAdmins()) {
            sysAdminsCount++;
            Object[] row = new Object[8];
            row[0]=sysAdminsCount;
            row[1]=sysAdmin;
            row[2]=sysAdmin.getUserName();
            row[3]=sysAdmin.getPassword();
            row[4]=sysAdmin.getEmail();
            row[5]=sysAdmin.getPhoneNo();
            row[6]=sysAdmin.getCreatedBy();
            row[7]=sysAdmin.getCreatedDate();
            
            sysAdminsModel.addRow(row);
        }
        countTotaljLabel.setText(String.valueOf(ecosystem.getSysAdminDirectory().getSysAdmins().size()));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cityjComboBox = new javax.swing.JComboBox<>();
        headerjLabel = new javax.swing.JLabel();
        proceedjButton = new javax.swing.JButton();
        headerjLabel1 = new javax.swing.JLabel();
        addCityjComboBox = new javax.swing.JComboBox<>();
        addCityjButton = new javax.swing.JButton();
        manageSysAdminsjLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        sysAdminsjTable = new javax.swing.JTable();
        countLablejLabel = new javax.swing.JLabel();
        countTotaljLabel = new javax.swing.JLabel();
        createjButton = new javax.swing.JButton();
        deletejButton = new javax.swing.JButton();
        updatejButton = new javax.swing.JButton();

        setBackground(java.awt.Color.cyan);
        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(java.awt.Color.cyan);

        headerjLabel.setFont(new java.awt.Font("Lucida Grande", 3, 18)); // NOI18N
        headerjLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerjLabel.setText("Please Select a City to Manage");

        proceedjButton.setText("Proceed >");
        proceedjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proceedjButtonActionPerformed(evt);
            }
        });

        headerjLabel1.setFont(new java.awt.Font("Lucida Grande", 3, 18)); // NOI18N
        headerjLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerjLabel1.setText("Select a City to Add");

        addCityjButton.setText("Add City");
        addCityjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCityjButtonActionPerformed(evt);
            }
        });

        manageSysAdminsjLabel.setFont(new java.awt.Font("Lucida Grande", 3, 18)); // NOI18N
        manageSysAdminsjLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        manageSysAdminsjLabel.setText("Manage System Admins");

        sysAdminsjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Serial No", "Name", "UserName", "Password", "Email", "Phone No", "Created By", "Created On"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(sysAdminsjTable);
        if (sysAdminsjTable.getColumnModel().getColumnCount() > 0) {
            sysAdminsjTable.getColumnModel().getColumn(0).setPreferredWidth(5);
        }

        countLablejLabel.setFont(new java.awt.Font("Lucida Grande", 3, 13)); // NOI18N
        countLablejLabel.setText("Count :");

        countTotaljLabel.setFont(new java.awt.Font("Lucida Grande", 3, 13)); // NOI18N
        countTotaljLabel.setText("0");

        createjButton.setText("Create >");
        createjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createjButtonActionPerformed(evt);
            }
        });

        deletejButton.setText("Delete");
        deletejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletejButtonActionPerformed(evt);
            }
        });

        updatejButton.setText("Update");
        updatejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatejButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(headerjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(headerjLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(177, 177, 177)
                                .addComponent(cityjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(242, 242, 242)
                                .addComponent(proceedjButton)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(209, 209, 209)
                                .addComponent(addCityjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(246, 246, 246)
                                .addComponent(addCityjButton))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(242, 242, 242)
                        .addComponent(manageSysAdminsjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 943, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(countLablejLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(countTotaljLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(updatejButton)
                                .addGap(18, 18, 18)
                                .addComponent(deletejButton)
                                .addGap(18, 18, 18)
                                .addComponent(createjButton)))))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(headerjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(headerjLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cityjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addCityjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(proceedjButton)
                    .addComponent(addCityjButton))
                .addGap(57, 57, 57)
                .addComponent(manageSysAdminsjLabel)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(countLablejLabel)
                    .addComponent(countTotaljLabel)
                    .addComponent(createjButton)
                    .addComponent(deletejButton)
                    .addComponent(updatejButton))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void proceedjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proceedjButtonActionPerformed
        // TODO add your handling code here:
        int selectedIndex = cityjComboBox.getSelectedIndex();
        
        CardLayout cardLayout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("adminMasterCityPanel",new SystemAdminManageCity(userProcessContainer,ecosystem,
                ecosystem.getCityNetworks().get(selectedIndex), userLogged));
        cardLayout.next(userProcessContainer);
    }//GEN-LAST:event_proceedjButtonActionPerformed

    private void addCityjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCityjButtonActionPerformed
        // TODO add your handling code here:
        
        for(CityNetwork cityNetwork:ecosystem.getCityNetworks()) {
            if(cityNetwork.getCityName().name().equalsIgnoreCase((String) addCityjComboBox.getSelectedItem())){
                JOptionPane.showMessageDialog(this, "City Already Exists. Please select another one");
                return;
            }
        }
        ecosystem.getCityNetworks().add(new CityNetwork(CityName.valueOf((String) addCityjComboBox.getSelectedItem()), new Date(), 
                new Date(), userLogged.getName(), userLogged.getName()));
        populateCities();
    }//GEN-LAST:event_addCityjButtonActionPerformed

    private void createjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createjButtonActionPerformed
        // TODO add your handling code here:
        CardLayout cardLayout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("CreateSysAdminPanel", new CreateNewSysAdminJPanel(userProcessContainer,ecosystem,userLogged));
        cardLayout.next(userProcessContainer);
    }//GEN-LAST:event_createjButtonActionPerformed

    private void updatejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatejButtonActionPerformed
        // TODO add your handling code here:
        int selectedSysAdmin = sysAdminsjTable.getSelectedRow();
        if(selectedSysAdmin < 0) {
            JOptionPane.showMessageDialog(this, "Please select a row to Update");
            return;
        }
        
        DefaultTableModel sysAdminsModel = (DefaultTableModel) sysAdminsjTable.getModel();
        SysAdmin sysAdmin = (SysAdmin) sysAdminsModel.getValueAt(selectedSysAdmin, 1);
        CardLayout cardLayout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("UpdateSysAdminPanel", new UpdateSysAdminJPanel(userProcessContainer,ecosystem,sysAdmin,userLogged));
        cardLayout.next(userProcessContainer);
    }//GEN-LAST:event_updatejButtonActionPerformed

    private void deletejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletejButtonActionPerformed
        // TODO add your handling code here:
        int selectedSysAdmin = sysAdminsjTable.getSelectedRow();
        if(selectedSysAdmin < 0) {
            JOptionPane.showMessageDialog(this, "Please select a row to Update");
            return;
        }
        
        DefaultTableModel sysAdminsModel = (DefaultTableModel) sysAdminsjTable.getModel();
        SysAdmin sysAdmin = (SysAdmin) sysAdminsModel.getValueAt(selectedSysAdmin, 1);
        if(ecosystem.getSysAdminDirectory().getSysAdmins().size()==1 || sysAdmin.getUserName().equals(userLogged.getUserName())){
            JOptionPane.showMessageDialog(this, "Cannot delete Yourself");
            return;
        }
        ecosystem.getSysAdminDirectory().getSysAdmins().remove(sysAdmin);
        populateSysAdmins();
    }//GEN-LAST:event_deletejButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addCityjButton;
    private javax.swing.JComboBox<String> addCityjComboBox;
    private javax.swing.JComboBox<String> cityjComboBox;
    private javax.swing.JLabel countLablejLabel;
    private javax.swing.JLabel countTotaljLabel;
    private javax.swing.JButton createjButton;
    private javax.swing.JButton deletejButton;
    private javax.swing.JLabel headerjLabel;
    private javax.swing.JLabel headerjLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel manageSysAdminsjLabel;
    private javax.swing.JButton proceedjButton;
    private javax.swing.JTable sysAdminsjTable;
    private javax.swing.JButton updatejButton;
    // End of variables declaration//GEN-END:variables
}
