package com.maciejak.futurum_task.service;

import com.maciejak.futurum_task.controller.dto.CampaignDTO;
import com.maciejak.futurum_task.domain.Campaign;

import java.util.List;

public interface CampaignService {

    CampaignDTO findCampaignByIdOrThrow(Long id);

    List<CampaignDTO> findAllCampaigns();

    void deleteCampaignById(Long id);

    void saveOrUpdateCampaign(CampaignDTO campaignDTO);

}
