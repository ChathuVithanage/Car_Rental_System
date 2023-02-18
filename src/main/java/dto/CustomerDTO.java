package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CustomerDTO {
    private String NIC;
    private byte[] NIC_img;
    private String license;
    private byte[] license_img;
    private String name;
    private int Contact;
    private String address;
    private String password;
}
