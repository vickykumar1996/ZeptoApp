package com.zepto.controller;

import com.zepto.entites.Booking;
import com.zepto.entites.Grocery;
import com.zepto.entites.User;
import com.zepto.exception.ResourceNotFoundException;
import com.zepto.payload.GroceryDto;
import com.zepto.repository.GroceryRepository;
import com.zepto.service.BookingService;
import com.zepto.service.GroceryServiceImpl;
import com.zepto.service.PdfService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/grocery/booking")
public class BookingController {
    private final PdfService pdfService;
    private final BookingService bookingService;
    private final GroceryRepository groceryRepository;

//    @PostMapping("/create-booking")
//    public ResponseEntity<Booking>createBooking(@RequestBody Booking booking){
//        Booking booking1 = bookingService.createBooking(booking);
//        return new ResponseEntity<>(booking1 , HttpStatus.CREATED);
//    }

    @PostMapping("/create-booking")
    public ResponseEntity<?>generateBookingPdf(@RequestParam long id ,
                                               @RequestBody Booking booking){

        String filePath = "S:\\Hms.booking\\confirmation-order.pdf";
        Grocery grocery = groceryRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("id is not present" + id) );
        Booking serviceBooking = bookingService.createBooking(booking);
        if (serviceBooking==null){
            return new ResponseEntity<>("your name or email is wrong" , HttpStatus.BAD_REQUEST);
        }
         pdfService.generatePdf(filePath , grocery , serviceBooking);
         return new ResponseEntity<>("pdf generate successFull" , HttpStatus.CREATED);
    }
}
