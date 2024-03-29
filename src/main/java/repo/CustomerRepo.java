package repo;

import entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer,String> {

    Customer findCustomerByNic(String nic);

}
