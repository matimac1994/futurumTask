package com.maciejak.futurum_task.controller.converter;

import com.maciejak.futurum_task.domain.Campaign;
import com.maciejak.futurum_task.controller.dto.CampaignDTO;
import com.maciejak.futurum_task.repository.TownRepository;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CampaignCampaignDTOConverter implements Converter<Campaign, CampaignDTO> {

    private final TownTownDTOConverter townTownDTOConverter;
    private final KeyWordToKeyWordDTOConverter keyWordToKeyWordDTOConverter;
    private final TownRepository townRepository;

    public CampaignCampaignDTOConverter(TownTownDTOConverter townTownDTOConverter,
                                        KeyWordToKeyWordDTOConverter keyWordToKeyWordDTOConverter,
                                        TownRepository townRepository) {
        this.townTownDTOConverter = townTownDTOConverter;
        this.keyWordToKeyWordDTOConverter = keyWordToKeyWordDTOConverter;
        this.townRepository = townRepository;
    }

    @Nullable
    @Override
    public CampaignDTO convert(Campaign campaign) {
        if (campaign == null){
            return null;
        }
        CampaignDTO campaignDTO = new CampaignDTO();
        campaignDTO.setId(campaign.getId());
        campaignDTO.setName(campaign.getName());
        campaignDTO.setMinAmount(campaign.getMinAmount());
        campaignDTO.setStatus(campaign.getStatus());
        campaignDTO.setRadius(campaign.getRadius());
        campaignDTO.setFund(campaign.getFund());

        if (campaign.getTown() != null)
            campaignDTO.setTown(townTownDTOConverter.convert(campaign.getTown()));

        if (campaign.getKeyWords().size() != 0){
            campaignDTO
                    .setKeyWords(
                            campaign
                                    .getKeyWords()
                                    .stream()
                                    .map(keyWordToKeyWordDTOConverter::convert)
                                    .collect(Collectors.toList())
                    );
        }

        return campaignDTO;
    }
}
