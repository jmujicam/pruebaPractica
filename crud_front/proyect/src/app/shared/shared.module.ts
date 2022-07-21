import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {MatButtonModule} from '@angular/material/button';
import {MatSidenavModule} from '@angular/material/sidenav';
import { RouterModule } from '@angular/router';
import {MatIconModule} from '@angular/material/icon';
import { MatListModule } from '@angular/material/list'; 
import {MatToolbarModule} from '@angular/material/toolbar';
import { HeaderComponent } from './components/header/header.component';
import { SidebarComponent } from './components/sidebar/sidebar.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    HeaderComponent,
    SidebarComponent
  ],
  imports: [
    CommonModule,
    RouterModule,
    MatButtonModule, 
    MatIconModule,
    MatSidenavModule,
    MatListModule,
    MatToolbarModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
  ],
  exports:[
    RouterModule,
    MatButtonModule, 
    MatIconModule,
    MatSidenavModule,
    MatListModule,

    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
  ]
})
export class SharedModule { }
