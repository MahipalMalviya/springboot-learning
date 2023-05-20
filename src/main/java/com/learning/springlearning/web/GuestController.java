package com.learning.springlearning.web;


import com.learning.springlearning.business.ReservationService;
import com.learning.springlearning.business.RoomReservation;
import com.learning.springlearning.data.Guest;
import com.learning.springlearning.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/guests")
public class GuestController {
    private final ReservationService reservationService;

    public GuestController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getAllGuests(Model model) {
        model.addAttribute("guests", this.reservationService.getAllGuests());
        return "hotel-guest";
    }
}
