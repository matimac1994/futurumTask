package com.maciejak.futurum_task.repository;

import com.maciejak.futurum_task.domain.Town;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TownRepository extends JpaRepository<Town, Long> {
}
