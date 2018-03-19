import {Routes} from "@angular/router";
import {CreateComponent} from "./components/create/create.component";
import {EditComponent} from "./components/edit/edit.component";
import {ListComponent} from "./components/list/list.component";
import {ShowComponent} from "./components/show/show.component";

export const appRoutes: Routes = [
    {
      path: '',
      redirectTo: '/list',
      pathMatch: 'full'
    },
    {
        path: 'create',
        component: CreateComponent
    },
    {
        path: 'edit/:id',
        component: EditComponent
    },
    {
        path: 'list',
        component: ListComponent
    },
    {
      path: 'show/:id',
      component: ShowComponent
    }
];
