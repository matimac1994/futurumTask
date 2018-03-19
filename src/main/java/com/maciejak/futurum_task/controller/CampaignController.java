package com.maciejak.futurum_task.controller;

import com.maciejak.futurum_task.controller.dto.CampaignDTO;
import com.maciejak.futurum_task.domain.Campaign;
import com.maciejak.futurum_task.service.CampaignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/campaign")
@Slf4j
public class CampaignController {

    private final CampaignService campaignService;

    public CampaignController(CampaignService campaignService) {
        this.campaignService = campaignService;
    }

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<List<CampaignDTO>> getAllCampaigns(){
        List<CampaignDTO> campaigns = campaignService.findAllCampaigns();
        log.info("getAllCampaigns size of response list: " + campaigns.size());
        return ResponseEntity.ok(campaigns);
    }

    @GetMapping("/{campaignId}")
    @ResponseBody
    public ResponseEntity<CampaignDTO> findCampaignById(@PathVariable(value = "campaignId")Long campaignId){
        CampaignDTO campaignDTO = campaignService.findCampaignByIdOrThrow(campaignId);
        log.info("findCampaignById response campaign on id: " + campaignId);
        return ResponseEntity.ok(campaignDTO);
    }

    @DeleteMapping("/{campaignId}")
    public ResponseEntity<Void> deleteCampaignById(@PathVariable(value = "campaignId") Long campaignId){
        campaignService.deleteCampaignById(campaignId);
        log.info("deleteCampaignById delete campaign on id: " + campaignId);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<Void> saveOrUpdateCampaign(@Valid @RequestBody CampaignDTO campaignDTO){
        campaignService.saveOrUpdateCampaign(campaignDTO);
        log.info("saveOrUpdateCampaign: " + campaignDTO.toString());
        return ResponseEntity.ok().build();
    }

}

