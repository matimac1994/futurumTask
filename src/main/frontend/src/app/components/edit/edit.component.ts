import {Component, Input, OnInit} from '@angular/core';
import {Campaign} from "../../model/Campaign";
import {CampaignService} from "../../services/campaign.service";
import {TownService} from "../../services/town.service";
import {Owner} from "../../model/Owner";
import {KeyWord} from "../../model/KeyWord";
import {Town} from "../../model/Town";
import {KeyWordService} from "../../services/key-word.service";
import {OwnerService} from "../../services/owner.service";
import {Location} from "@angular/common";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {

  @Input() campaign: Campaign;
  towns: Town[] = [];
  keyWords: KeyWord[] = [];
  owner: Owner;

  constructor(
    private campaignService: CampaignService,
    private townService: TownService,
    private keyWordService: KeyWordService,
    private ownerService: OwnerService,
    private location: Location,
    private route: ActivatedRoute

) { }

  ngOnInit() {
    this.getCampaignById();
    this.getTowns();
    this.getKeyWords();
    this.getOwner();
  }

  private getCampaignById(){
    const id = +this.route.snapshot.paramMap.get('id');
    this.campaignService.getCampaignById(id).subscribe(
      (campaign: any) => this.campaign = campaign
    )
  }

  private getTowns() {
    this.townService.getAllTowns().subscribe(
      (towns: any[]) => this.towns = towns
    );
  }

  private getKeyWords() {
    this.keyWordService.getKeyWords().subscribe(
      (keyWords: any[]) => this.keyWords = keyWords
    );
  }

  processForm(campaign: Campaign) {
    console.log(campaign);
    this.campaignService.saveOrUpdateCampaign(campaign).subscribe(
      () => this.location.back()
    );
  }

  private getOwner() {
    this.ownerService.getOwnerById(1).subscribe(
      (owner: any) => this.owner = owner
    )
  }

}
