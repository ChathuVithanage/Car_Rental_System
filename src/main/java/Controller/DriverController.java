package Controller;

import Service.CustomerService;
import Service.DriverService;
import dto.CustomerDTO;
import dto.DriverDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import util.ResponseUtil;

@RestController
@CrossOrigin
@RequestMapping("/driver")
public class DriverController {

    @Autowired
    private DriverService service;

    @PostMapping
    public ResponseUtil saveDriver(@ModelAttribute DriverDTO dto){
        service.saveDriver(dto);
        return new ResponseUtil("OK","Successfully Registered.!",null);
    }

//    @DeleteMapping(params = {"license"})
//    public ResponseUtil deleteDriver(@RequestParam String license){
//        service.deleteDriver(license);
//        return new ResponseUtil("ok","deleteDriver",null);
//    }

    @DeleteMapping(params = "license")
    public ResponseUtil deleteCustomer(@RequestParam String license) {
        service.deleteDriver(license);
        return new ResponseUtil("OK", "Successfully Deleted. :" + license, null);
    }


    @PutMapping
    public ResponseUtil updateDriver(@RequestBody DriverDTO dto){
        service.updateDriver(dto);
        return new ResponseUtil("OK","Successfully Updated. :"+dto.getLicense() ,null);
    }

    @GetMapping
    public ResponseUtil getAllDrivers(){
        return new ResponseUtil("OK","Successfully Loaded. :" ,service.getAllDrivers());
    }

//    @GetMapping(path = "/{license}")
//    public ResponseUtil searchDriverByLicense(@PathVariable String license){
//        return new ResponseUtil("OK","Successfully Loaded. :" ,service.searchDriverWithLicense(license));
//    }
//
    @GetMapping(params = {"license"})
    public ResponseUtil searchDriverByLicense(String license){
        return new ResponseUtil("OK","Successfully Loaded. :" ,service.searchDriverWithLicense(license));
    }


}
