import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment.local";
import {Campaign} from "../model/Campaign";

@Injectable()
export class CampaignService {

  campaignEndPointUrl: string = environment.apiUrl + "/campaign";

  constructor(private http: HttpClient) { }

  getCampaigns(){
    return this.http.get(this.campaignEndPointUrl + "/all");
  }

  getCampaignById(campaignId: number){
    return this.http.get(this.campaignEndPointUrl + "/" + campaignId);
  }

  deleteCampaignById(campaignId: number){
    return this.http.delete(this.campaignEndPointUrl + "/" + campaignId);
  }

  saveOrUpdateCampaign(campaign : Campaign){
    return this.http.post(this.campaignEndPointUrl, campaign);
  }
}
