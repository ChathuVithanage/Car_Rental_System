package Controller;

import Service.CustomerService;
import dto.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import util.ResponseUtil;

@RestController
@CrossOrigin
@RequestMapping("/customer")

public class CustomerController {

    @Autowired
    private CustomerService service;

    @PostMapping
    public ResponseUtil saveCustomer(@ModelAttribute CustomerDTO dto){
        service.saveCustomer(dto);
        return new ResponseUtil("OK","Successfully Registered.!",null);
    }

  /*  @DeleteMapping(params = "NIC")
    public ResponseUtil deleteCustomer(@RequestParam String NIC){
        service.deleteCustomer(NIC);
        return new ResponseUtil("OK","Successfully Deleted. :"+NIC ,null);
    }*/
    @DeleteMapping(params = {"nic"})
    public ResponseUtil DeleteCustomer(@RequestParam String nic){
        service.DeleteCustomer(nic);
        return new ResponseUtil("ok","DeleteCustomer",null);
    }

    @PutMapping
    public ResponseUtil updateCustomer(@RequestBody CustomerDTO dto){
        service.updateCustomer(dto);
        return new ResponseUtil("OK","Successfully Updated. :"+dto.getNic() ,null);
    }

    @GetMapping
    public ResponseUtil getAllCustomers(){
        return new ResponseUtil("OK","Successfully Loaded. :" ,service.getAllCustomers());
    }

//    @GetMapping(path = "/{NIC}")
////    public ResponseUtil searchCustomerByNIC(@PathVariable String NIC){
////        return new ResponseUtil("OK","Successfully Loaded. :" ,service.searchCustomerWithNIC(NIC));
////    }

    @GetMapping(params = {"NIC"})
    public ResponseUtil searchCustomerByNIC(String NIC){
        return new ResponseUtil("OK","Successfully Loaded. :" ,service.searchCustomerWithNIC(NIC));
    }
}
