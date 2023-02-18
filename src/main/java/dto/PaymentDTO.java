package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class PaymentDTO {
    private String accountNo;
    private String paymentMethod;
    private String deduction;
    private String damageWeiver;
    private String rent;
    private Date date;
}
