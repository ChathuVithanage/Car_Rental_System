package Controller;

import Service.AddCarService;
import Service.BookingService;
import Service.CustomerService;
import Service.DriverService;
import dto.BookingDTO;
import dto.PaymentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import util.ResponseUtil;

import java.math.BigDecimal;

@RestController
@RequestMapping("/booking")
@CrossOrigin
public class BookingController {
    @Autowired
    private BookingService service;
    @Autowired
    private AddCarService addCarService;
    @Autowired
    private DriverService driverService;
    @Autowired
    private CustomerService customerService;


    @GetMapping
    public ResponseUtil getAllBooking(){
        System.out.println("get all");
        return new ResponseUtil("ok","getAll",service.getAllBooking());
    }
    /*  @GetMapping(params = {"bookingID"})
      public ResponseUtil generateBookingId(){

          return new ResponseUtil("ok","generateId",service.generateBookingId());
      }*/
    @RequestMapping(value = "/place", method = RequestMethod.POST)
    public ResponseUtil placeBooking(
            @RequestParam BigDecimal advancePayment,
            @RequestParam String bookingId,
            @RequestParam  String currentDateTime,
            @RequestParam String dueDateTime,
            @RequestParam boolean isAccepted,
            @RequestPart("paymentConfirmation") byte[] conf,
            @RequestParam String user,
            @RequestParam(required = false) String driver,
            @RequestParam String car,
            @RequestParam BigDecimal rent
    ) {

        System.out.println("start");
        BookingDTO dto1 = new BookingDTO(bookingId,currentDateTime,dueDateTime,advancePayment,conf,isAccepted,rent, addCarService.findCarByVehicleNo(car),driverService.findDriverByLicense(driver), customerService.searchCustomerWithNIC(user));
        PaymentDTO dto2 = new PaymentDTO(dto1.getBookingID(),rent);
        service.placeBooking(dto1,dto2);
        return new ResponseUtil("OK","Successfully Added.!",null);
    }

    @GetMapping(params = {"driverID"})
    public ResponseUtil getBookingDetails(String driverID){
        return new ResponseUtil("ok","shedule",service.findBookingByDrivingId(driverID));
    }
    @GetMapping(params = {"option"})
    public ResponseUtil countAllBooking(){
        return new ResponseUtil("ok","count",service.countBooking());
    }
    @GetMapping(params = {"bookingID"})
    public ResponseUtil findbookings(String bookingID){
        System.out.println("jjjjjj"+bookingID);
        return new ResponseUtil("ok","find",service.findBookingbookingID(bookingID));
    }
}
