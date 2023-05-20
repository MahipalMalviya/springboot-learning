package com.learning.springlearning.web;


import com.learning.springlearning.business.ReservationService;
import com.learning.springlearning.business.RoomReservation;
import com.learning.springlearning.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/reservations")
public class RoomReservationController {

    private final DateUtils dateUtils;
    private final ReservationService reservationService;

    @Autowired
    public RoomReservationController(DateUtils dateUtils, ReservationService reservationService) {
        this.dateUtils = dateUtils;
        this.reservationService = reservationService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getReservations(@RequestParam(value = "date", required = false) String dateString, Model model) {
        Date date = this.dateUtils.createDateFromDateString(dateString);
        List<RoomReservation> reservationList = this.reservationService.getRoomReservationsForDate(date);
        model.addAttribute("roomReservations", reservationList);
        return "roomres";
    }
}
