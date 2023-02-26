package repo;

import entity.Customer;
import entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepo extends JpaRepository<Driver,String> {
    Driver findDriverByLicense(String license);
}
