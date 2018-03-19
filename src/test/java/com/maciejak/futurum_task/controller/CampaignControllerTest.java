package com.maciejak.futurum_task.controller;

import com.maciejak.futurum_task.service.Impl.CampaignServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class CampaignControllerTest {

    @Mock
    private CampaignServiceImpl campaignService;

    private CampaignController campaignController;

    @Before
    public void setUp(){

        MockitoAnnotations.initMocks(this);

        campaignController = new CampaignController(campaignService);
    }

    @Test
    public void findCampaignById(){

    }

}
