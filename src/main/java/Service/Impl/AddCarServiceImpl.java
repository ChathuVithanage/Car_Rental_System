package Service.Impl;

import dto.CarDTO;
import entity.Car;
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
        return null;
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
    public ArrayList<CarDTO> findCarByVehicleNo(){
//        return mapper.map(repo.findCarByVehicleNo(vehicleNo),CarDTO.class);
        return null;
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
