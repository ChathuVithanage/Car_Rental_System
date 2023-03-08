package Service;

import dto.BookingDTO;
import dto.PaymentDTO;

import java.util.ArrayList;

public interface BookingService  {
    void saveBooking(BookingDTO dto);
    String generateBookingId();
    ArrayList<BookingDTO> getAllBooking();
    long countBooking();
    BookingDTO findBookingByDrivingId(String driverID);
    BookingDTO findBookingbookingID(String bookingID);
    public void placeBooking(BookingDTO dto1, PaymentDTO dto2);

}
