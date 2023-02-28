package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Car {
    @Id
    private String vehicleNo;
    private String brand;
    private String model;
    private int mileage;
    private String color;
    private int passengers;
    private String type;
    private String fuelType;
    private String transmission;
    private int serviceMileage;
    private boolean isAvailable;
    private BigDecimal extraPrice;
    private BigDecimal dailyRate;
    private BigDecimal monthlyRate;
    private int freeMileageForDay;
    private int freeMileageForMonth;

    @Lob
    private byte[] img_front;
    @Lob
    private byte[] img_back;
    @Lob
    private byte[] img_side;
    @Lob
    private byte[] img_interior;

//    @OneToMany(mappedBy = "car")
//    private Collection<Booking> bookings = new ArrayList<>();

    public Car(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }
}
