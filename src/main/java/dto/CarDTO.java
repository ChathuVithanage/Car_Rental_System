package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Lob;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CarDTO {
    private String vehicleNo;
    private String type;
    private int passengers;
    private String color;
    private Double dailyPrice;
    private Double MonthlyPrice;
    private String serviceMileage;
    private String FreeMileage;
    //@Lob
//    private byte[] image;
    private boolean availability;
    private String model;
    private Double priceForExtraKm;
    private String transmissionType;
    private String FuelType;
}
