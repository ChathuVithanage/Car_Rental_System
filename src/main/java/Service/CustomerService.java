package Service;

import dto.CustomerDTO;

import java.util.ArrayList;

public interface CustomerService {
    public void saveCustomer(CustomerDTO dto);
    /*public void deleteCustomer(String NIC);*/
    public void updateCustomer(CustomerDTO dto);
    public ArrayList<CustomerDTO> getAllCustomers();
    void DeleteCustomer(String NIC);
    public CustomerDTO searchCustomerWithNIC(String NIC);
}
