package com.example.demo.repository;
        import com.example.demo.model.Visitor;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.stereotype.Repository;

        import java.util.List;
        import java.util.Optional;

@Repository
public interface VisitorRepository extends JpaRepository<Visitor, Long> {
    // Spring generates the dynamic query infrastructure execution code behind this signature
    Optional findByName(String name);
}
