package Service;

import dto.AdminDTO;
import dto.CustomerDTO;

import java.util.ArrayList;

public interface AdminRegService {
    public void saveAdmin(AdminDTO dto);
    /*public void deleteCustomer(String NIC);*/
    public void updateAdmin(AdminDTO dto);
    public ArrayList<AdminDTO> getAllAdmin();
    void DeleteAdmin(String nic);
    public AdminDTO searchAdminWithNIC(String nic);
}
