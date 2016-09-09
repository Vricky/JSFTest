/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.io.Serializable;
//import javax.faces.bean.ManagedBean;              //用ManagedBean时需要的包
//import javax.faces.bean.SessionScoped;            //用ManagedBean时需要的包
import javax.inject.Named;                          //用@Named时需要的包
import javax.enterprise.context.SessionScoped;      //用@Named时需要的包
/**
 *
 * @author Vricky
 */
//@ManagedBean
@Named
@SessionScoped
public class BankForm implements Serializable{

    /**
     * Creates a new instance of BankForm
     */
    public BankForm() {
    }
    
    private String customerid;
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getCustomerid() {
        return customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid;
    }
    
    private static CustomerLookupService lookupService = new CustomerSimpleMap();
    
    public String findBalance() {
        customer = lookupService.findCustomer(customerid);
        if (customer == null) {
            return("unknown-customer");
        } else {
            return("show-customer");
        }
    }
    
    interface CustomerLookupService{
        public Customer findCustomer(String id);
    }
}
