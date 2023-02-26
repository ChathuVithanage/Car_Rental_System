package Service;

import dto.DriverDTO;
import entity.Driver;

import java.util.ArrayList;

public interface DriverService {
    public Driver saveDriver(DriverDTO dto);
    public void deleteDriver(String license);
    public void updateDriver(DriverDTO dto);
    public ArrayList<DriverDTO> getAllDrivers();

    public DriverDTO searchDriverWithLicense(String license);
}
