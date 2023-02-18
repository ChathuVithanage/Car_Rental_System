package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Car {
    @Id
    private String vehicleNo;
    private String type;
    private int passengers;
    private String color;
    private Double price;
    private String serviceMileage;
    private String FreeMileage;
    @Lob
    private byte[] image;
    private boolean availability;
    private String model;
    private Double priceForExtraKm;
    private String transmissionType;
    private String FuelType;

}
