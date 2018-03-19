import {Component, Input, OnInit, ViewChild} from '@angular/core';
import {Campaign} from "../../model/Campaign";
import {TownService} from "../../services/town.service";
import {Town} from "../../model/Town";
import {KeyWord} from "../../model/KeyWord";
import {Location} from "@angular/common";
import {KeyWordService} from "../../services/key-word.service";
import {CampaignService} from "../../services/campaign.service";
import {OwnerService} from "../../services/owner.service";
import {Owner} from "../../model/Owner";

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {

  @Input() campaign: Campaign = new Campaign();
  towns: Town[] = [];
  keyWords: KeyWord[] = [];
  owner: Owner;

  constructor(
    private campaignService: CampaignService,
    private townService: TownService,
    private keyWordService: KeyWordService,
    private ownerService: OwnerService,
    private location: Location
  ) { }

  ngOnInit() {
    this.getTowns();
    this.getKeyWords();
    this.getOwner();
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
