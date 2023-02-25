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
    private String nic;
    private byte[] nic_img;
    private String license;
    private byte[] license_img;
    private String name;
    private int contact;
    private String address;
    private String password;
}
