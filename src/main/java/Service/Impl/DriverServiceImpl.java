package Service.Impl;

import dto.CustomerDTO;
import dto.DriverDTO;

import entity.Customer;
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
    public Driver saveDriver(DriverDTO dto) {
        if (repo.existsById(dto.getLicense())){
            throw new RuntimeException("Driver Already Exist. Please enter another id..!");
        }
        repo.save(mapper.map(dto, Driver.class));
        return null;
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
            throw new RuntimeException("Driver Not Exist. Please Enter Valid ID..!");
        }
        repo.save(mapper.map(dto, Driver.class));
    }

    @Override
    public ArrayList<DriverDTO> getAllDrivers() {
        return mapper.map(repo.findAll(),new TypeToken<ArrayList<DriverDTO>>(){}.getType());
    }

    @Override
    public DriverDTO searchDriverWithLicense(String license) {
        Driver driver = repo.findDriverByLicense(license);
        if (driver.isAvailable()) {
            return mapper.map(driver,DriverDTO.class);
        }
        return null;
    }

//    @Override
//    public DriverDTO searchDriverWithLicense(String license) {
//        Optional<Driver> driver = repo.findDriverByLicense(li);
//        if (driver.isPresent()) {
//            return mapper.map(driver,DriverDTO.class);
//        }
//        return null;
//    }







}
