package Controller;

import Service.AddCarService;
import dto.CarDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import util.ResponseUtil;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

@CrossOrigin
@RestController
@RequestMapping("/car")
public class AddCarController {

    @Autowired
    AddCarService addCarService;

    @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseUtil saveCar(
            @RequestParam String vehicleNo,
            @RequestParam String brand,
            @RequestParam String model,
            @RequestParam int mileage,
            @RequestParam String color,
            @RequestParam int passengers,
            @RequestParam String type,
            @RequestParam String fuelType,
            @RequestParam String transmission,
            @RequestParam int serviceMileage,
            @RequestParam boolean isAvailable,
            @RequestParam BigDecimal extraPrice,
            @RequestParam BigDecimal dailyRate,
            @RequestParam BigDecimal monthlyRate,
            @RequestParam int freeMileageForMonth,
            @RequestParam int freeMileageForDay,
           @RequestPart("file1") MultipartFile file1,
           @RequestPart("file2") MultipartFile file2,
           @RequestPart("file3") MultipartFile file3,
           @RequestPart("file4") MultipartFile file4
    ) throws IOException {

        CarDTO dto = new CarDTO(vehicleNo,brand,model,mileage,color,passengers,type,fuelType,transmission,serviceMileage,isAvailable,extraPrice,dailyRate,monthlyRate,freeMileageForMonth,freeMileageForDay,file1.getBytes(),file2.getBytes(),file3.getBytes(),file4.getBytes());
        addCarService.saveCar(dto);
        return new ResponseUtil("OK","Successfully Registered.!",null);

    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseUtil updateCar(
            @RequestParam String vehicleNo,
            @RequestParam String brand,
            @RequestParam String model,
            @RequestParam int mileage,
            @RequestParam String color,
            @RequestParam int passengers,
            @RequestParam String type,
            @RequestParam String fuelType,
            @RequestParam String transmission,
            @RequestParam int serviceMileage,
            @RequestParam boolean isAvailable,
            @RequestParam BigDecimal extraPrice,
            @RequestParam BigDecimal dailyRate,
            @RequestParam BigDecimal monthlyRate,
            @RequestParam int freeMileageForMonth,
            @RequestParam int freeMileageForDay,
            @RequestPart(value = "file1", required = false) MultipartFile file1,
            @RequestPart(value = "file2", required = false) MultipartFile file2,
            @RequestPart(value = "file3", required = false) MultipartFile file3,
            @RequestPart(value = "file4", required = false) MultipartFile file4
    ) throws IOException {

        CarDTO dto = new CarDTO(vehicleNo,brand,model,mileage,color,passengers,type,fuelType,transmission,serviceMileage,isAvailable,extraPrice,dailyRate,monthlyRate,freeMileageForMonth,freeMileageForDay,file1.getBytes(),file2.getBytes(),file3.getBytes(),file4.getBytes());
        addCarService.updateCar(dto);
        return new ResponseUtil("OK","Successfully Updated.!",null);

    }

    @RequestMapping(value = "/remove", method = RequestMethod.DELETE)
    public ResponseUtil removeCar(@RequestParam String vehicleNo){
        addCarService.deleteCar(vehicleNo);
        return new ResponseUtil("OK","Successfully Deleted.!",null);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseUtil getAllCar(){
        ArrayList<CarDTO> data = addCarService.getAllCars();
        return new ResponseUtil("OK","Successful!",data);
    }

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public ResponseUtil getAllCar(@RequestParam String vehicleNo){
//        CarDTO data = addCarService.findCarByVehicleNo(vehicleNo);
//        return new ResponseUtil("OK","Successful!",data);
        return null;
    }

//    @RequestMapping(value = "/countCarsByAvailabilityIsTrue", method = RequestMethod.GET)
//    public ResponseUtil countCarsByAvailabilityIsTrue(){
//        return new ResponseUtil("OK","Successful!",addCarService.countCarsByAvailableIsTrue());
//    }
//
//    @RequestMapping(value = "/countCarsScheduled", method = RequestMethod.GET)
//    public ResponseUtil countCarsScheduled(){
//        return new ResponseUtil("OK","Successful!",AddCarService.countCarsScheduled());
//    }


}