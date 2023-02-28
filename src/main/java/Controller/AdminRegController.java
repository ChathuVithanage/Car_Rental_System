package Controller;

import Service.AdminRegService;
import Service.CustomerService;
import dto.AdminDTO;
import dto.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import util.ResponseUtil;

@RestController
@CrossOrigin
@RequestMapping("/adminReg")

public class AdminRegController {

    @Autowired
    private AdminRegService service;

    @PostMapping
    public ResponseUtil saveCustomer(@ModelAttribute AdminDTO dto){
        service.saveAdmin(dto);
        return new ResponseUtil("OK","Successfully Registered.!",null);
    }

    /*  @DeleteMapping(params = "NIC")
      public ResponseUtil deleteCustomer(@RequestParam String NIC){
          service.deleteCustomer(NIC);
          return new ResponseUtil("OK","Successfully Deleted. :"+NIC ,null);
      }*/
    @DeleteMapping(params = {"nic"})
    public ResponseUtil DeleteAdmin(@RequestParam String nic){
        service.DeleteAdmin(nic);
        return new ResponseUtil("ok","DeleteCustomer",null);
    }

    @PutMapping
    public ResponseUtil updateAdmin(@RequestBody AdminDTO dto){
        service.updateAdmin(dto);
        return new ResponseUtil("OK","Successfully Updated. :"+dto.getNic() ,null);
    }

    @GetMapping
    public ResponseUtil getAllAdmin(){
        return new ResponseUtil("OK","Successfully Loaded. :" ,service.getAllAdmin());
    }

//    @GetMapping(path = "/{NIC}")
////    public ResponseUtil searchCustomerByNIC(@PathVariable String NIC){
////        return new ResponseUtil("OK","Successfully Loaded. :" ,service.searchCustomerWithNIC(NIC));
////    }

    @GetMapping(params = {"nic"})
    public ResponseUtil searchAdminByNIC(String nic){
        return new ResponseUtil("OK","Successfully Loaded. :" ,service.searchAdminWithNIC(nic));
    }
}
