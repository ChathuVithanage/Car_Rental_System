package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Booking {
    @Id
    private String bookingID;
    private String currentDate;
    private String dueDate;
    private BigDecimal advancePayment;
    @Lob
    private byte[] paymentConfirmation;

    private BigDecimal rent;
    private boolean isAccepted;
    @ManyToOne
    private Car car;
    @ManyToOne
    private Driver driver;
    /*@ManyToOne
    private Admin admin;*/
    @ManyToOne
    private Customer customer;
}
