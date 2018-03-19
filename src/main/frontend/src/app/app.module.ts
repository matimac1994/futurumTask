import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { ListComponent } from './components/list/list.component';
import { EditComponent } from './components/edit/edit.component';
import { ShowComponent } from './components/show/show.component';
import { CreateComponent } from './components/create/create.component';
import {RouterModule} from "@angular/router";
import {appRoutes} from "./routerConfig";
import {HttpClientModule} from "@angular/common/http";
import {CampaignService} from "./services/campaign.service";
import {FormsModule} from "@angular/forms";
import {TownService} from "./services/town.service";
import {KeyWordService} from "./services/key-word.service";
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";
import {OwnerService} from "./services/owner.service";


@NgModule({
  declarations: [
    AppComponent,
    ListComponent,
    EditComponent,
    ShowComponent,
    CreateComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(appRoutes),
    HttpClientModule,
    FormsModule,
    NgbModule.forRoot()
  ],
  providers: [CampaignService, TownService, KeyWordService, OwnerService],
  bootstrap: [AppComponent]
})
export class AppModule { }
