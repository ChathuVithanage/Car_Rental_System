package Service.Impl;

import dto.CarDTO;
import dto.CustomerDTO;
import entity.Car;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repo.CarRepo;
import Service.AddCarService;

import java.util.ArrayList;
import java.util.Optional;

@Service
@Transactional
public class AddCarServiceImpl implements AddCarService {

    @Autowired
    private CarRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void saveCar(CarDTO dto) {
        if (repo.existsById(dto.getVehicleNo())){
            throw new RuntimeException("Car Already Exist. Please enter another id..!");
        }
        repo.save(mapper.map(dto, Car.class));
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
    public void updateCar(CarDTO dto) {
        if (!repo.existsById(dto.getVehicleNo())){
            throw new RuntimeException("Car Not Exist. Please Enter Valid ID..!");
        }
        repo.save(mapper.map(dto, Car.class));
    }

    @Override
    public ArrayList<CarDTO> getAllCars() {
        return mapper.map(repo.findAll(),new TypeToken<ArrayList<CarDTO>>(){}.getType());
    }

    @Override
    public void DeleteCar(String vehicleNo) {
        if(!repo.existsById(vehicleNo)){
            throw new RuntimeException("invalid id");
        }
        repo.deleteById(vehicleNo);
    }

    @Override
    public CarDTO searchCarWithVehicleNo(String vehicleNo) {

        if (!repo.existsById(vehicleNo)){
            throw new RuntimeException("invalid id");

        }
        Car car = repo.findCarByVehicleNo(vehicleNo);
        CarDTO map = mapper.map(car,CarDTO.class);
        return map;
    }

}
