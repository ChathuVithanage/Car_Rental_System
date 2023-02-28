package Service.Impl;

import dto.AdminDTO;
import dto.CustomerDTO;
import entity.Admin;
import entity.Customer;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repo.AdminRepo;
import repo.CustomerRepo;
import Service.AdminRegService;

import java.util.ArrayList;
import java.util.Optional;

@Service
@Transactional
public class AdminRegServiceImpl implements AdminRegService {

    @Autowired
    private AdminRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void saveAdmin(AdminDTO dto) {
        if (repo.existsById(dto.getNic())){
            throw new RuntimeException("Admin Already Exist. Please enter another id..!");
        }
        repo.save(mapper.map(dto, Admin.class));
    }
/*
    @Override
    public void deleteCustomer(String NIC) {
        if (!repo.existsById(NIC)){
            throw new RuntimeException("Wrong ID..Please enter valid id..!");
        }
        repo.deleteById(NIC);
    }*/

    @Override
    public void updateAdmin(AdminDTO dto) {
        if (!repo.existsById(dto.getNic())){
            throw new RuntimeException("Admin Not Exist. Please Enter Valid ID..!");
        }
        repo.save(mapper.map(dto, Admin.class));
    }

    @Override
    public ArrayList<AdminDTO> getAllAdmin() {
        return mapper.map(repo.findAll(),new TypeToken<ArrayList<AdminDTO>>(){}.getType());
    }

    @Override
    public void DeleteAdmin(String nic) {
        if(!repo.existsById(nic)){
            throw new RuntimeException("invalid id");
        }
        repo.deleteById(nic);
    }

    @Override
    public AdminDTO searchAdminWithNIC(String nic) {
//        Optional<Customer> customer = repo.findById(NIC);
//        if (customer.isPresent()) {
//            return mapper.map(customer,CustomerDTO.class);
//        }
//        return null;
        if (!repo.existsById(nic)){
            throw new RuntimeException("invalid id");

        }
        Admin admin = repo.findAdminByNic(nic);
        AdminDTO map = mapper.map(admin,AdminDTO.class);
        return map;
    }

}
