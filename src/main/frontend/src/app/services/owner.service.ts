import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment.local";

@Injectable()
export class OwnerService {

  ownerEndPointUrl: string = environment.apiUrl + "/owner";

  constructor(private http: HttpClient) { }

  getOwnerById(ownerId: number){
    return this.http.get(this.ownerEndPointUrl + "/" + ownerId);
  }
}
