import { Routes } from '@angular/router';
import { Home } from './home/home';
import { Login } from './login/login';
import { Librarian } from './librarian/librarian';
import { Student } from './student/student';

export const routes: Routes = [{
    path:"",
    component:Login
},{
    path:"home",
    component:Home
},{
    path:"librarian",
    component:Librarian
},{
    path:"student",
    component:Student
}];
