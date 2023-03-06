package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class PaymentDTO {
    private String bookingId;
    private String accountNo;
    private String paymentMethod;
    private String deduction;
    private String damageWeiver;
    private BigDecimal rent;
    private Date date;

    public PaymentDTO(String bookingId, BigDecimal rent) {
        this.bookingId = bookingId;
        this.rent = rent;
    }
}
