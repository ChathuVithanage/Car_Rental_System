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
    DriverDTO findDriverRandomly(String date1, String date2);
    DriverDTO findDriverByLicense(String license);
}
