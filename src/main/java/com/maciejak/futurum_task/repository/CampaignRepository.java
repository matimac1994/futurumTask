package com.maciejak.futurum_task.repository;

import com.maciejak.futurum_task.domain.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampaignRepository extends JpaRepository<Campaign, Long> {
}
