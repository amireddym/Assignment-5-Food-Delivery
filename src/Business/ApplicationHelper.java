/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Customer.Customer;
import Business.DeliveryMan.DeliveryMan;
import Business.Employee.RestaurantEmployee;
import Business.Restaurant.Restaurant;
import Business.SysAdmin.SysAdmin;

/**
 *
 * @author manojreddy
 */
public class ApplicationHelper {
    
    public static boolean checkUserNameAlreadyExists(EcoSystem ecoSystem, String userName) {
        
        for(SysAdmin sysAdmin:ecoSystem.getSysAdminDirectory().getSysAdmins()) {
            if(sysAdmin.getUserName().contentEquals(userName)){
                return true;
            }
        }
        
        for(Customer customer:ecoSystem.getCustomerDirectory().getCustomers()) {
            if(customer.getUserName().contentEquals(userName)) {
                return true;
            }
        }
        
        for(CityNetwork cityNetwork:ecoSystem.getCityNetworks()) {
            for(DeliveryMan deliveryMan:cityNetwork.getDeliveryManDirectory().getDeliveryMan()){
                if(deliveryMan.getUserName().contentEquals(userName)){
                    return true;
                }
            }
            
            for(Restaurant restaurant:cityNetwork.getRestaurantDirectory().getRestaurants()) {
                for(RestaurantEmployee restaurantEmployee:restaurant.getRestaurantEmployeeDirectory().getEmployeeList()) {
                    if(restaurantEmployee.getUserName().contentEquals(userName)) {
                        return true;
                    }
                }
            }
        }
        return false;

    }
    
}
