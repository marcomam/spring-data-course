package br.com.spring.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.spring.data.entity.Merchant;

@Repository
public interface MerchantRepository extends JpaRepository<Merchant, Integer> {

}
