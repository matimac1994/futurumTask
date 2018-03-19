package com.maciejak.futurum_task.controller.converter;

import com.maciejak.futurum_task.controller.dto.CampaignDTO;
import com.maciejak.futurum_task.domain.Campaign;
import com.maciejak.futurum_task.domain.Product;
import com.maciejak.futurum_task.repository.ProductRepository;
import com.maciejak.futurum_task.repository.TownRepository;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CampaignDTOCampaignConverter implements Converter<CampaignDTO, Campaign> {

    private final TownDTOTownConverter townDTOTownConverter;
    private final KeyWordDTOToKeywordConverter keyWordDTOToKeywordConverter;
    private final ProductRepository productRepository;
    private final TownRepository townRepository;

    public CampaignDTOCampaignConverter(TownDTOTownConverter townDTOTownConverter,
                                        KeyWordDTOToKeywordConverter keyWordDTOToKeywordConverter,
                                        ProductRepository productRepository,
                                        TownRepository townRepository) {
        this.townDTOTownConverter = townDTOTownConverter;
        this.keyWordDTOToKeywordConverter = keyWordDTOToKeywordConverter;
        this.productRepository = productRepository;
        this.townRepository = townRepository;
    }

    @Nullable
    @Override
    public Campaign convert(CampaignDTO campaignDTO) {
        if (campaignDTO == null){
            return null;
        }
        Campaign campaign = new Campaign();
        campaign.setId(campaignDTO.getId());
        campaign.setName(campaignDTO.getName());
        campaign.setMinAmount(campaignDTO.getMinAmount());
        campaign.setStatus(campaignDTO.getStatus());
        campaign.setRadius(campaignDTO.getRadius());
        campaign.setFund(campaignDTO.getFund());
        if (campaignDTO.getTown() != null)
            campaign.setTown(townRepository.getOne(campaignDTO.getTown().getId()));

        if (campaignDTO.getKeyWords() != null){
            campaign
                    .setKeyWords(
                            campaignDTO
                                    .getKeyWords()
                                    .stream()
                                    .map(keyWordDTOToKeywordConverter::convert)
                                    .collect(Collectors.toList())
                    );
        }

        campaign.setProduct(productRepository.getOne(1L));

        return campaign;
    }

}
