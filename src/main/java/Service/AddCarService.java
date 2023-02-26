package Service;

import dto.CarDTO;
import dto.CustomerDTO;
import entity.Car;

import java.util.ArrayList;

public interface AddCarService {
    public void saveCar(CarDTO dto);
    public void updateCar(CarDTO dto);
    public ArrayList<CarDTO> getAllCars();
    void DeleteCar(String vehicleNo);
    public CarDTO searchCarWithVehicleNo(String vehicleNo);
}
