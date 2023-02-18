package Service;

import dto.CustomerDTO;
import dto.DriverDTO;

import java.util.ArrayList;

public interface DriverService {
    public void saveDriver(DriverDTO dto);
    public void deleteDriver(String license);
    public void updateDriver(DriverDTO dto);
    public ArrayList<DriverDTO> getAllDrivers();

    public DriverDTO searchDriverWithLicense(String license);
}
