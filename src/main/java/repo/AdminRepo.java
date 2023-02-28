package repo;

import entity.Admin;
import entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepo extends JpaRepository<Admin,String> {
    Admin findAdminByNic(String nic);
}
