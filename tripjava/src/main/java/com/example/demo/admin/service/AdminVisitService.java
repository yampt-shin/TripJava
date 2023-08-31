package com.example.demo.admin.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.admin.repository.AdminVisitRepository;
import com.example.demo.entity.Visit;

@Service
public class AdminVisitService {
    @Autowired
    private AdminVisitRepository adminVisitRepository;

    public List<Visit> getAllVisits() {
        return adminVisitRepository.findAll();
    }
    public int getTodatyVisits() {
    	Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        Date startOfToday = calendar.getTime();
        Date endOfToday = new Date();
        List<Visit> todayVisits = adminVisitRepository.findAllByVisitDateBetween(startOfToday, endOfToday);

        int todayVisitCount = 0;
        for (Visit visit : todayVisits) {
            todayVisitCount += visit.getVisitCount();
        }

        return todayVisitCount;
    }
    
    public List<Visit> getVisitsForLast7Days() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -7); // Get the date 7 days ago
        Date startDate = calendar.getTime();
        Date endDate = new Date(); // Current date

        return adminVisitRepository.findAllByVisitDateBetween(startDate, endDate);
    }
    
    public void addOrUpdateVisitCountForToday() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0); // Set the hour of day to 00:00:00 (start of the day)
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        Date startOfToday = calendar.getTime();
        Date endOfToday = new Date(); // Current date (which includes the current time)

        List<Visit> visits = adminVisitRepository.findAllByVisitDateBetween(startOfToday, endOfToday);

        if (visits.isEmpty()) {
            // If there is no data for today's date, add new data with count 1
            Visit visit = new Visit();
            visit.setVisitDate(endOfToday); // Save the current date as the visit date
            visit.setVisitCount(1);
            adminVisitRepository.save(visit);
        } else {
            // If data for today's date exists, increase the visit count by one
            Visit visit = visits.get(0);
            int currentVisitCount = visit.getVisitCount();
            visit.setVisitCount(currentVisitCount + 1);
            adminVisitRepository.save(visit);
        }
    }
}
