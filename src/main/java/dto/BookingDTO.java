package dto;

import entity.Car;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Lob;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class BookingDTO {
    private String bookingID;
    private String currentDate;
    private String dueDate;
    private BigDecimal advancePayment;
    private byte[] paymentConfirmation;
    private boolean isAccepted;
    private BigDecimal rent;
    private CarDTO car;
    private DriverDTO driver;
    /*private AdminDTO admin;*/
    private CustomerDTO customer;
}
