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
        if(!repo.existsById(license)){
            throw new RuntimeException("invalid id");
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
        if (!repo.existsById(license)){
            throw new RuntimeException("invalid driver id");
        }
        Driver driver=repo.findDriverByLicense(license);
        DriverDTO dto=mapper.map(driver,DriverDTO.class);
        return dto;
    }

    @Override
    public DriverDTO findDriverRandomly(String date1, String date2) {
        return mapper.map(repo.selectDriverRandomly(date1 ,date2),DriverDTO.class);
    }

    @Override
    public DriverDTO findDriverByLicense(String license) {
        return mapper.map(repo.findDriverByLicense(license),DriverDTO.class);
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
