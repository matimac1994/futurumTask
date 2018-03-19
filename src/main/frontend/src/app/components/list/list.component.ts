import {Component, OnInit} from '@angular/core';
import {Campaign} from "../../model/Campaign";
import {CampaignService} from "../../services/campaign.service";

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  gaetCampaigns(): any {
    throw new Error("Method not implemented.");
  }

  campaigns: Campaign[] = [];

  constructor(private campaignService: CampaignService) { }

  ngOnInit() {
    this.getCampaigns();
  }

  private getCampaigns() {
    return this.campaignService.getCampaigns().subscribe(
      (campaigns: any[]) => {
        this.campaigns = campaigns;
      }
    );
  }

  deleteCampaignById(id: number){
    console.log("delete campaign: " + id);
    this.campaignService.deleteCampaignById(id).subscribe(
      () => this.getCampaigns()
    );
  }

}
