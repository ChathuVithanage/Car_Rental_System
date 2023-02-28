package entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Customer {
    @Id
    private String nic;
    //private String NIC_img;
    private String license;
    //private String license_img;
    private String name;
    private int contact;
    private String address;
    private String password;

//    @OneToMany(mappedBy = "user")
//    @JsonManagedReference
//    private Collection<Booking> bookings = new ArrayList<>();


}
