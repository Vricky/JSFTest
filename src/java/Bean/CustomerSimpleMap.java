package Bean;

import Bean.BankForm.CustomerLookupService;
import java.util.HashMap;
import java.util.Map;

public class CustomerSimpleMap implements CustomerLookupService {
    private Map<String,Customer> customers;
    
    public CustomerSimpleMap() {
        customers = new HashMap<String,Customer>();
        addCustomer(new Customer("id001", "有财", "杨", -3456.78));
        addCustomer(new Customer("id002", "有财1", "杨1", 123));
        addCustomer(new Customer("id003", "有财2", "杨2", 2324));
        addCustomer(new Customer("id004", "有财3", "杨3", 222222));
    }
    
    private void addCustomer(Customer customer){
        customers.put(customer.getId(), customer);
    }
    
    @Override
    public Customer findCustomer(String id) {
        if (id != null) {
            return(customers.get(id.toLowerCase()));
        } else {
            return (null);
        }
    }
    
}