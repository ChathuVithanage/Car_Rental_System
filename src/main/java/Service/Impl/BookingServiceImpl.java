package Service.Impl;

import Service.BookingService;
import com.sun.xml.internal.ws.message.source.PayloadSourceMessage;
import dto.BookingDTO;
import dto.PaymentDTO;
import entity.Booking;
import entity.Payment;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repo.BookingRepo;
import repo.PaymentRepo;

import java.util.ArrayList;
@Service
@Transactional

public class BookingServiceImpl implements BookingService {
    @Autowired
    BookingRepo repo;
    @Autowired
    PaymentRepo repo2;
    @Autowired
    private ModelMapper mapper;

    @Override
    public void placeBooking(BookingDTO dto1, PaymentDTO dto2) {
        repo.save(mapper.map(dto1, Booking.class));
        repo2.save(mapper.map(dto2, Payment.class));
    }

    @Override
    public void saveBooking(BookingDTO dto) {
        String s = generateBookingId();
        dto.setBookingID(s);
    }

    @Override
    public String generateBookingId() {
        return null;
    }

    @Override
    public ArrayList<BookingDTO> getAllBooking() {
        return null;
    }

    @Override
    public long countBooking() {
        return 0;
    }

    @Override
    public BookingDTO findBookingByDrivingId(String driverID) {
        return null;
    }

    @Override
    public BookingDTO findBookingbookingID(String bookingID) {
        return null;
    }
}
