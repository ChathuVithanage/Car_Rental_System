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
public class Driver {
    @Id
    private String license;
    private String name;
    private int Contact;
    private String address;
    private String available;

//    @OneToMany(mappedBy = "driver")
//    @JsonManagedReference
//    private Collection<Booking> bookings = new ArrayList<>();

    public Driver(String name) {
        this.name = name;
    }
}
