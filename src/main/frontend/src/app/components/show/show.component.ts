import { Component, OnInit } from '@angular/core';
import {CampaignService} from "../../services/campaign.service";
import {Campaign} from "../../model/Campaign";
import {Location} from "@angular/common";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-show',
  templateUrl: './show.component.html',
  styleUrls: ['./show.component.css']
})
export class ShowComponent implements OnInit {

  campaign: Campaign;

  constructor(
    private campaignService: CampaignService,
    private location: Location,
    private route: ActivatedRoute
  ) { }

  ngOnInit() {
    this.getCampaign();

  }

  private getCampaign() {
    const id = +this.route.snapshot.paramMap.get('id');
    console.log("get campaign: " + id);
    this.campaignService.getCampaignById(id).subscribe(
      (campaign: any) => this.campaign = campaign
    );
  }

  deleteCampaignById(id: number){
    console.log("delete campaign: " + id);
    this.campaignService.deleteCampaignById(id).subscribe();
    this.location.back()
  }

}
