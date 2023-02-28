package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class AdminDTO {
    @Id
    private String nic;
    private String userName;
    private String name;
    private String password;
    private String email;
}
