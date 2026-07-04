package com.example.demo.service;

import com.example.demo.model.Visitor;
import com.example.demo.repository.VisitorRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;

@Service
public class VisitorService {
    private final VisitorRepository visitorRepository;

    public VisitorService(VisitorRepository visitorRepository){
        this.visitorRepository = visitorRepository;
    }

    @Transactional
    public List<Visitor> getVisitor() {
        // Query the database structure for an existing name profile record
        return  visitorRepository.findAll();
    }

    public Visitor getVisitorById( long id) {
        return  visitorRepository.getById(id);
    }

    public Visitor addVisitor( Visitor visitor) {
        return  visitorRepository.save(visitor);
    }

    public Visitor updateVisitor( long id, Visitor visitor) {
        Visitor v = visitorRepository.getById(id);
        v.setVisitCount(visitor.getVisitCount());
        return visitorRepository.save(v);
    }

    public void deleteVisitor( long id) {
        visitorRepository.deleteById(id);
    }






}
