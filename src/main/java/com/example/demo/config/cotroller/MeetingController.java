package com.example.demo.config.cotroller;

import com.example.demo.config.Reservation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MeetingController {

    private List<Reservation> bookedMeetings = new ArrayList<>();

    @GetMapping("/meeting")
    public String showMeetingForm(Model model) {
        model.addAttribute("reservations", bookedMeetings);
        return "meetingForm";
    }

    @PostMapping("/bookMeeting")
    public String bookMeeting(@ModelAttribute Reservation reservation, Model model) {
        bookedMeetings.add(reservation);
        return "redirect:/meeting";
    }
//------------------------------------------------------------------------------------------------------
    @GetMapping("/reservation")
    public String reservationForm(Model model) {
        model.addAttribute("reservation", new Reservation());
        return "reservation";
    }

    @PostMapping("/reservation")
    public String reservationSubmit(@ModelAttribute Reservation reservation, Model model) {
        model.addAttribute("reservation", reservation);
        return "result";
    }
}


