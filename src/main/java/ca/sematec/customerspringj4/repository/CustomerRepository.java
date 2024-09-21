package ca.sematec.customerspringj4.repository;


import ca.sematec.customerspringj4.model.Customer;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
@Query("FROM Customer ")
    public List<Customer> findByName( Pageable pageable);

}
