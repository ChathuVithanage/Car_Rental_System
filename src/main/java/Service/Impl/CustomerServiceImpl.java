package Service.Impl;

import dto.CustomerDTO;
import entity.Customer;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repo.CustomerRepo;
import Service.CustomerService;

import java.util.ArrayList;
import java.util.Optional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void saveCustomer(CustomerDTO dto) {
        if (repo.existsById(dto.getNIC())){
            throw new RuntimeException("Customer Already Exist. Please enter another id..!");
        }
        repo.save(mapper.map(dto, Customer.class));
    }

    @Override
    public void deleteCustomer(String NIC) {
        if (!repo.existsById(NIC)){
            throw new RuntimeException("Wrong ID..Please enter valid id..!");
        }
        repo.deleteById(NIC);
    }

    @Override
    public void updateCustomer(CustomerDTO dto) {
        if (!repo.existsById(dto.getNIC())){
            throw new RuntimeException("Customer Not Exist. Please Enter Valid ID..!");
        }
        repo.save(mapper.map(dto, Customer.class));
    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomers() {
        return mapper.map(repo.findAll(),new TypeToken<ArrayList<CustomerDTO>>(){}.getType());
    }

    @Override
    public CustomerDTO searchCustomerWithNIC(String NIC) {
//        Optional<Customer> customer = repo.findById(NIC);
//        if (customer.isPresent()) {
//            return mapper.map(customer,CustomerDTO.class);
//        }
//        return null;
        if (!repo.existsById(NIC)){
            throw new RuntimeException("invalid id");

        }
        Customer customer = repo.findCustomerByNIC(NIC);
        CustomerDTO map = mapper.map(customer,CustomerDTO.class);
        return map;
    }

}
