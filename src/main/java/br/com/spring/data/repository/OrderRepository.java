package br.com.spring.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.spring.data.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
