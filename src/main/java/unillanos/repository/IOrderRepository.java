package unillanos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unillanos.model.Order;

@Repository
public interface IOrderRepository extends JpaRepository<Order, Long> {
}
