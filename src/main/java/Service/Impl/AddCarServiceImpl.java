package Service.Impl;

import dto.CarDTO;
import dto.CustomerDTO;
import entity.Car;
import entity.Customer;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repo.CarRepo;
import Service.AddCarService;

import javax.transaction.Transactional;
import java.util.ArrayList;

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
            throw new RuntimeException("Car Already Exist!");
        }
        repo.save(mapper.map(dto, Car.class));
    }

    @Override
    public void deleteCar(String vehicleNo) {
        if (!repo.existsById(vehicleNo)){
            throw new RuntimeException("Wrong Registration Number..Please enter a valid number !");
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

    @Override
    public void updateCar(CarDTO dto) {
        if (!repo.existsById(dto.getVehicleNo())){
            throw new RuntimeException("Car Doesn't Exist. Please Enter Valid identifier..!");
        }
        repo.save(mapper.map(dto, Car.class));
    }

    @Override
    public ArrayList<CarDTO> getAllCars() {
        return mapper.map(repo.findAll(),new TypeToken<ArrayList<CarDTO>>(){}.getType());
    }

    @Override
    public CarDTO findCarByVehicleNo(String regNo){
        return mapper.map(repo.findCarByVehicleNo(regNo),CarDTO.class);
    }

//
//    @Override
//    public int countCarsByAvailableIsTrue() {
////        return repo.countCarsByAvailableIsTrue();
//    }

//    @Override
//    public int countCarsScheduled() {
//        return repo.countCarsScheduled();
//    }
}
