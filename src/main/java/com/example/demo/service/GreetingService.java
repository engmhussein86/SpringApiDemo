package com.example.demo.service;

import com.example.demo.model.Visitor;
import com.example.demo.repository.VisitorRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;


import java.time.LocalTime;

@Service // This tells Spring to manage this class as a business logic component
public class GreetingService {
    private final VisitorRepository visitorRepository;
    // Inject the Repository dependency
    public GreetingService(VisitorRepository visitorRepository) {
        this.visitorRepository = visitorRepository;}

    @Transactional
    public String generateGreeting(String name) {
        // Query the database structure for an existing name profile record
        Visitor visitor = (Visitor) visitorRepository.findByName(name).orElse(new Visitor(name, 0));
        // Increment tracking metadata metrics
        visitor.setVisitCount(visitor.getVisitCount() + 1);
        visitorRepository.save(visitor);
        // Compute runtime presentation variables
        int hour = LocalTime.now().getHour();
        String timeGreeting = (hour < 12) ? "Good morning, " : (hour < 17) ? "Good afternoon, " : "Good evening, ";
        return timeGreeting + visitor.getName() + "! You have visited this endpoint " + visitor.getVisitCount() + " time(s).";
    }
}