package Service.Impl;

import config.WebRootConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import repo.CustomerRepo;

import static org.junit.jupiter.api.Assertions.*;

@WebAppConfiguration  //create  testing conterx
@ContextConfiguration(classes = {WebRootConfig.class}) //configuration add krnwa context ekata
@ExtendWith(SpringExtension.class) //junit ekk intrigarate kranne meke
class CustomerServiceImplTest {

    @Autowired
    CustomerRepo repo;
    @Test
    void deleteCustomer() {
        repo.deleteById("123")
        ;

    }
}