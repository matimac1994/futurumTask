package com.maciejak.futurum_task.repository;

import com.maciejak.futurum_task.domain.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
}
