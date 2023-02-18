package Service.Impl;

import dto.DriverDTO;

import entity.Driver;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repo.DriverRepo;
import Service.DriverService;

import java.util.ArrayList;
import java.util.Optional;

@Service
@Transactional
public class DriverServiceImpl implements DriverService {

    @Autowired
    private DriverRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void saveDriver(DriverDTO dto) {
        if (repo.existsById(dto.getLicense())){
            throw new RuntimeException("Customer Already Exist. Please enter another id..!");
        }
        repo.save(mapper.map(dto, Driver.class));
    }

    @Override
    public void deleteDriver(String license) {
        if (!repo.existsById(license)){
            throw new RuntimeException("Wrong ID..Please enter valid id..!");
        }
        repo.deleteById(license);
    }

    @Override
    public void updateDriver(DriverDTO dto) {
        if (!repo.existsById(dto.getLicense())){
            throw new RuntimeException("Customer Not Exist. Please Enter Valid ID..!");
        }
        repo.save(mapper.map(dto, Driver.class));
    }

    @Override
    public ArrayList<DriverDTO> getAllDrivers() {
        return mapper.map(repo.findAll(),new TypeToken<ArrayList<DriverDTO>>(){}.getType());
    }

    @Override
    public DriverDTO searchDriverWithLicense(String license) {
        Optional<Driver> driver = repo.findById(license);
        if (driver.isPresent()) {
            return mapper.map(driver,DriverDTO.class);
        }
        return null;
    }


}
