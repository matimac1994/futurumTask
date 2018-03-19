import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment.local";

@Injectable()
export class TownService {

  townEndPointUrl: string = environment.apiUrl + "/town/";

  constructor(private http: HttpClient) { }

  getAllTowns(){
    return this.http.get(this.townEndPointUrl + "/all");
  }
}
