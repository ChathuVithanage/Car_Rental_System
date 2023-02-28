package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Transient;
import java.io.ByteArrayInputStream;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.SQLException;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class BookingDTO {
    private String bookingId;
    private LocalDate currenDateTime;
    private LocalDate dueDateTime;
    private BigDecimal advancePayment;
    private byte[] paymentConfirmation;
    private boolean isAccepted;

    private String carId;

    private String driverId;

    private String userId;


    private CarDTO car;
    private DriverDTO driver;
    private AdminDTO admin;
    private CustomerDTO customer;
    private ByteArrayInputStream conf;

    public BookingDTO(String id, LocalDate currenDateTime, LocalDate dueDateTime, BigDecimal advancePayment, byte[] paymentConfirmation, boolean isAccepted, CarDTO car, DriverDTO driver, CustomerDTO customer) {
        this.bookingId = id;
        this.currenDateTime = currenDateTime;
        this.dueDateTime = dueDateTime;
        this.advancePayment = advancePayment;
        this.paymentConfirmation = paymentConfirmation;
        this.isAccepted = isAccepted;
        this.car = car;
        this.driver = driver;
        this.customer = customer;

    }
}