package repo;

import entity.Customer;
import entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DriverRepo extends JpaRepository<Driver,String> {
    Driver findDriverByLicense(String license);
    @Query(value = "select * from Driver WHERE Driver.license NOT IN (select Booking.driver_license from Booking) OR Driver.license NOT IN (select Booking.driver_license from Booking where :date1 between Booking.currentDate and Booking.dueDate) AND Driver.license NOT IN (select Booking.driver_license from Booking where :date2 between Booking.currentDate and Booking.dueDate) ORDER BY RAND() LIMIT 1",nativeQuery = true)
    Driver selectDriverRandomly(@Param("date1") String date1, @Param("date2") String date2 );
}
