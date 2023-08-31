package com.example.demo.admin.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.admin.service.AdminAccomodationRvService;
import com.example.demo.admin.service.AdminAccomodationService;
import com.example.demo.admin.service.AdminActivityRvService;
import com.example.demo.admin.service.AdminActivityService;
import com.example.demo.admin.service.AdminUsersService;
import com.example.demo.admin.service.AdminVisitService;
import com.example.demo.entity.Visit;

import lombok.Setter;

@Setter
@Controller
public class AdminVisitController {
    @Autowired
    private AdminVisitService vs;
    @Autowired
    private AdminUsersService us;
    @Autowired
    private AdminActivityService activityservice;
    @Autowired
    private AdminAccomodationService accomodationservice;
    @Autowired
    private AdminActivityRvService ars;
    @Autowired
    private AdminAccomodationRvService acrs;

    @GetMapping("/admin/adminPage")
    public String list(Model model,
    		@PathVariable(required = false) Date accomodation_rv_date,
    		@PathVariable(required = false) Date accomodation_review_date,
    		@PathVariable(required = false) Date activity_rv_date,
    		@PathVariable(required = false) Date activity_review_date,
    		@PathVariable(required = false) Date users_date,
    		@PathVariable(required = false) Date visit_date) {
        model.addAttribute("list", vs.getAllVisits());
        model.addAttribute("todayVisit",vs.getTodatyVisits());
        model.addAttribute("last7DaysData",vs.getVisitsForLast7Days());
        model.addAttribute("totalUsers", us.getTotalRecord());
        model.addAttribute("totalActivity", activityservice.getActivityTotalRecord());
        model.addAttribute("totalAccomodation", accomodationservice.getAccomodationTotalRecord());
        model.addAttribute("totalActivityRv", ars.getActivityRvTotalRecord());
        model.addAttribute("totalAccomodationRv", acrs.getAccomodationRvTotalRecord());
        vs.addOrUpdateVisitCountForToday();
        return "/admin/adminPage";
    }
    
    @GetMapping("/dashboard-data")
    @ResponseBody
    public List<Visit> getDashboardData() {
        return vs.getVisitsForLast7Days();
    }
    
    
//    @GetMapping("/mainpage")
//    public void updateVisitCountForToday() {
//        vs.addOrUpdateVisitCountForToday();
//    }
}