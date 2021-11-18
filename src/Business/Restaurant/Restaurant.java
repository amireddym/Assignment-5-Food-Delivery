/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Restaurant;

import Business.Employee.RestaurantEmployeeDirectory;
import Business.ModificationInfo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author harold
 */
public class Restaurant {
    
    private String restaurantName;
    
    private String phoneNo;
    
    private String address;
    
    private List<MenuItem> menuItems = new ArrayList<>();
    
    private RestaurantEmployeeDirectory restaurantEmployeeDirectory = new RestaurantEmployeeDirectory();
    
    private List<Order> orders = new ArrayList<>();

    public Restaurant(String restaurantName, String phoneNo, String address) {
        this.restaurantName = restaurantName;
        this.phoneNo = phoneNo;
        this.address = address;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public RestaurantEmployeeDirectory getRestaurantEmployeeDirectory() {
        return restaurantEmployeeDirectory;
    }

    public void setRestaurantEmployeeDirectory(RestaurantEmployeeDirectory restaurantEmployeeDirectory) {
        this.restaurantEmployeeDirectory = restaurantEmployeeDirectory;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
    
}
