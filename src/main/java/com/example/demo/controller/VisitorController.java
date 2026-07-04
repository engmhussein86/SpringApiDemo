package com.example.demo.controller;

import com.example.demo.model.Visitor;
import com.example.demo.service.VisitorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VisitorController {
    private final VisitorService visitorService;
    record visitorRequest(String name, int visitsCount){}

    public VisitorController(VisitorService visitorService){
        this.visitorService = visitorService;
    }

    // This handles requests to http://localhost:8080/visitor
    @GetMapping("/visitor")
    public List<Visitor> getVisitor() {
        // Delegate the business logic execution to the service tier
        return visitorService.getVisitor();
    }

    // This handles requests to http://localhost:8080/visitorId/1
    @GetMapping("/visitorId/{id}")
    public Visitor getVisitorById(@PathVariable("id") long id) {
        // Delegate the business logic execution to the service tier
        return visitorService.getVisitorById(id);
    }

    // This handles requests to http://localhost:8080/visitorId
    @PostMapping("/addVisitor")
    public Visitor addVisitor(@RequestBody visitorRequest request ) {
        Visitor visitor = new Visitor();
        visitor.setName(request.name());
        visitor.setVisitCount(request.visitsCount());
        return visitorService.addVisitor(visitor);
    }

    // This handles requests to http://localhost:8080/visitorId
    @PutMapping("/updateVisitor/{id}")
    public Visitor updateVisitor(@PathVariable("id") long id,@RequestBody visitorRequest request ) {
        Visitor visitor = new Visitor();
        visitor.setName(request.name());
        visitor.setVisitCount(request.visitsCount());
        return visitorService.updateVisitor(id,visitor);
    }

    @DeleteMapping("/deleteVisitor/{id}")
    public void deleteVisitor(@PathVariable("id") long id) {
        // Delegate the business logic execution to the service tier
         visitorService.deleteVisitor(id);
    }
}
