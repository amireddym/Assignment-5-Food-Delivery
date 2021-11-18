/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.SystemAdminWorkArea.SystemAdminWorkAreaJPanel;

/**
 *
 * @author manojreddy
 */
public class JpanelManager {
    
    public static JPanel getMasterPanel(JPanel userProcessContainer, EcoSystem ecoSystem, UserAccount userLogged){
        
        return new SystemAdminWorkAreaJPanel(userProcessContainer, ecoSystem, userLogged);
    }
    
    
}
