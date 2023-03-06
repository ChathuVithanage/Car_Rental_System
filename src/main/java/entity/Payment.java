package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Payment {
    @Id
    private String bookingId;
    private String accountNo;
    private String paymentMethod;
    private String deduction;
    private String damageWeiver;
    private BigDecimal rent;
    private Date date;

}
