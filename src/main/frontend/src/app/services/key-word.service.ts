import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment.local";

@Injectable()
export class KeyWordService {

  keyWordEndPointUrl: string = environment.apiUrl + "/keyword";

  constructor(private http: HttpClient) { }

  getKeyWords(){
    return this.http.get(this.keyWordEndPointUrl + "/all");
  }
}
