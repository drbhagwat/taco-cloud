package tacos.data;

import org.springframework.data.repository.CrudRepository;

import tacos.Order;
import tacos.Taco;

import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long>  {
  Order save(Order order);
}