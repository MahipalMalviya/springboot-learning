package com.learning.springlearning.webservice;

import com.learning.springlearning.business.ReservationService;
import com.learning.springlearning.business.RoomReservation;
import com.learning.springlearning.data.Guest;
import com.learning.springlearning.data.Room;
import com.learning.springlearning.util.DateUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class WebServiceRestController {
    private final DateUtils dateUtils;
    private final ReservationService reservationService;

    public WebServiceRestController(DateUtils dateUtils, ReservationService reservationService) {
        this.dateUtils = dateUtils;
        this.reservationService = reservationService;
    }

    @GetMapping(path = "/reservations")
    public List<RoomReservation> getReservations(@RequestParam(value = "date", required = false) String dateString) {
        Date date = this.dateUtils.createDateFromDateString(dateString);
        return this.reservationService.getRoomReservationsForDate(date);
    }

    @GetMapping(path = "/guests")
    public List<Guest> getGuests() {
        return this.reservationService.getAllGuests();
    }

    @PostMapping(path = "/guests")
    @ResponseStatus(HttpStatus.CREATED)
    public void addGuest(@RequestBody Guest guest) {
        this.reservationService.addGuest(guest);
    }

    @GetMapping(path = "/rooms")
    public List<Room> getRooms() {
        return this.reservationService.getRooms();
    }
}
