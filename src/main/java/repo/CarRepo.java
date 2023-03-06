package repo;

import entity.Car;
import entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CarRepo extends JpaRepository<Car,String> {
    Car findCarByVehicleNo(String vehicleNo);
    //    available cars
//   int countCarsByAvailableIsTrue();
    //    cars scheduled
//    @Query(value = "select COUNT(*) from Car INNER JOIN Booking ON Car.vehicleNo = Booking.car_vehicleNo ",nativeQuery = true)
//    int countCarsScheduled();


}
