package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import repo.CarRepo;

import javax.persistence.Id;
import javax.persistence.Lob;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CarDTO{
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
    private byte[] img_front;
    private byte[] img_back;
    private byte[] img_side;
    private byte[] img_interior;

//    public CarDTO(String vehicleNo, String brand, String model, int mileage, String color, int passengers, String type, String fuelType, String transmission, int serviceMileage, boolean isAvailable, BigDecimal extraPrice, BigDecimal dailyRate, BigDecimal monthlyRate, int freeMileageForDay, int freeMileageForMonth) {
//        this.vehicleNo = vehicleNo;
//        this.brand = brand;
//        this.model = model;
//        this.mileage = mileage;
//        this.color = color;
//        this.passengers = passengers;
//        this.type = type;
//        this.fuelType = fuelType;
//        this.transmission = transmission;
//        this.serviceMileage = serviceMileage;
//        this.isAvailable = isAvailable;
//        this.extraPrice = extraPrice;
//        this.dailyRate = dailyRate;
//        this.monthlyRate = monthlyRate;
//        this.freeMileageForDay = freeMileageForDay;
//        this.freeMileageForMonth = freeMileageForMonth;
//    }
}
