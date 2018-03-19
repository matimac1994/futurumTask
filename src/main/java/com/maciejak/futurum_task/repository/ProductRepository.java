package com.maciejak.futurum_task.repository;

import com.maciejak.futurum_task.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
