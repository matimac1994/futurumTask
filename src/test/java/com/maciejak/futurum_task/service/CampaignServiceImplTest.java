package com.maciejak.futurum_task.service;

import com.maciejak.futurum_task.controller.converter.CampaignCampaignDTOConverter;
import com.maciejak.futurum_task.controller.converter.CampaignDTOCampaignConverter;
import com.maciejak.futurum_task.controller.dto.CampaignDTO;
import com.maciejak.futurum_task.domain.Campaign;
import com.maciejak.futurum_task.exception.NotFoundException;
import com.maciejak.futurum_task.repository.CampaignRepository;
import com.maciejak.futurum_task.service.Impl.CampaignServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

public class CampaignServiceImplTest {

    @Mock
    CampaignRepository campaignRepository;

    @Mock
    CampaignDTOCampaignConverter campaignDTOCampaignConverter;

    @Mock
    CampaignCampaignDTOConverter campaignCampaignDTOConverter;

    private CampaignServiceImpl campaignService;

    @Before
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);

        campaignService = new CampaignServiceImpl(campaignRepository, campaignCampaignDTOConverter, campaignDTOCampaignConverter);
    }

    @Test
    public void findCampaignByIdOrThrow() throws Exception {
        Long ID = 1L;
        String NAME = "Test name";

        Campaign campaign = new Campaign();
        campaign.setId(ID);
        campaign.setName(NAME);

        when(campaignRepository.findById(ID)).thenReturn(Optional.of(campaign));

        CampaignDTO campaignDTO = new CampaignDTO();
        campaignDTO.setId(ID);
        campaignDTO.setName(NAME);

        when(campaignCampaignDTOConverter.convert(any())).thenReturn(campaignDTO);

        CampaignDTO campaign1 = campaignService.findCampaignByIdOrThrow(ID);

        assertNotNull(campaign1);
        assertEquals(campaign1.getId(), ID);
        assertEquals(campaign1.getName(), NAME);
    }

    @Test(expected = NotFoundException.class)
    public void findCampaignByIdOrThrowShouldThrowWhenNull() throws Exception {
        campaignService.findCampaignByIdOrThrow(null);
    }

    @Test(expected = NotFoundException.class)
    public void findCampaignByIdOrThrowShouldThrowWhenNotFound() throws Exception {
        campaignService.findCampaignByIdOrThrow(1L);
    }

    @Test
    public void findAllCampaigns() throws Exception {
    }

    @Test
    public void deleteCampaignById() throws Exception {
    }

    @Test(expected = NotFoundException.class)
    public void deleteCampaignByIdShouldThrow() throws Exception {
        campaignService.deleteCampaignById(1L);
    }

    @Test
    public void saveOrUpdateCampaign() throws Exception {
    }

}