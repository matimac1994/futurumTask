package com.maciejak.futurum_task.service.Impl;

import com.maciejak.futurum_task.controller.converter.CampaignCampaignDTOConverter;
import com.maciejak.futurum_task.controller.converter.CampaignDTOCampaignConverter;
import com.maciejak.futurum_task.controller.dto.CampaignDTO;
import com.maciejak.futurum_task.domain.Campaign;
import com.maciejak.futurum_task.exception.BadRequestException;
import com.maciejak.futurum_task.exception.NotFoundException;
import com.maciejak.futurum_task.repository.CampaignRepository;
import com.maciejak.futurum_task.service.CampaignService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CampaignServiceImpl implements CampaignService {

    private final CampaignRepository campaignRepository;
    private final CampaignCampaignDTOConverter campaignCampaignDTOConverter;
    private final CampaignDTOCampaignConverter campaignDTOCampaignConverter;

    public CampaignServiceImpl(CampaignRepository campaignRepository,
                               CampaignCampaignDTOConverter campaignCampaignDTOConverter,
                               CampaignDTOCampaignConverter campaignDTOCampaignConverter) {
        this.campaignRepository = campaignRepository;
        this.campaignCampaignDTOConverter = campaignCampaignDTOConverter;
        this.campaignDTOCampaignConverter = campaignDTOCampaignConverter;
    }

    @Override
    public CampaignDTO findCampaignByIdOrThrow(Long id) {
        return campaignCampaignDTOConverter.convert(findCampaignById(id));
    }

    @Override
    public List<CampaignDTO> findAllCampaigns() {
        return campaignRepository
                .findAll()
                .stream()
                .map(campaignCampaignDTOConverter::convert)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteCampaignById(Long id) {
        Campaign campaign = findCampaignById(id);
        campaignRepository.delete(campaign);
    }

    @Override
    @Transactional
    public void saveOrUpdateCampaign(CampaignDTO campaignDTO) {
        Campaign campaign = campaignDTOCampaignConverter.convert(campaignDTO);
        if (campaign != null){
            if (campaign.getId() != null){
                Campaign campaignFromDb = campaignRepository.getOne(campaign.getId());
                Double emeraldAccount = campaign.getProduct().getOwner().getEmeraldAccount();
                campaign.getProduct().getOwner().setEmeraldAccount(emeraldAccount - (campaign.getFund() - campaignFromDb.getFund()));
            } else {
                Double emeraldAccount = campaign.getProduct().getOwner().getEmeraldAccount();
                campaign.getProduct().getOwner().setEmeraldAccount(emeraldAccount - campaign.getFund());
            }
            campaignRepository.save(campaign);

        }
        else
            throw new BadRequestException("Campaign can't be empty");
    }

    private Campaign findCampaignById(Long id){
        Optional<Campaign> campaign = campaignRepository.findById(id);

        if (!campaign.isPresent())
            throw new NotFoundException("Can't found campaign");

        return campaign.get();
    }
}
