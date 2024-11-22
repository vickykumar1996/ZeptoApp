package com.zepto.service;

import com.zepto.entites.Booking;
import com.zepto.entites.User;
import com.zepto.repository.BookingRepository;
import com.zepto.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final UserRepo userRepo;

    public Booking createBooking(Booking booking) {
       String name = booking.getName();
       String email = booking.getEmail();

        boolean nameExists = userRepo.existsByName(name);
        boolean emailExists = userRepo.existsByName(name);

        if (nameExists && emailExists){
            Booking save = bookingRepository.save(booking);
            return save;
        }else {
            return null;
        }
    }
}
