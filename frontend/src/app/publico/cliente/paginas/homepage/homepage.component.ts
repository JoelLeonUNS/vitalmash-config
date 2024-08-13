import { Component } from '@angular/core';
import { NzCardModule } from 'ng-zorro-antd/card';
import { NzButtonModule } from 'ng-zorro-antd/button';
import { NzGridModule } from 'ng-zorro-antd/grid';
import { CommonModule } from '@angular/common';
import { HeaderComponent } from "../../../../core/header/header.component";

@Component({
  selector: 'app-homepage',
  standalone: true,
  imports: [
    CommonModule,
    NzCardModule,
    NzButtonModule,
    NzGridModule,
    HeaderComponent
  ],
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent {
  products = [
    {
      title: 'Producto 1',
      description: 'Descripción breve del producto 1',
      image: 'assets/image1.png'
    },
    {
      title: 'Producto 2',
      description: 'Descripción breve del producto 2',
      image: 'assets/image2.png'
    },
    {
      title: 'Producto 3',
      description: 'Descripción breve del producto 3',
      image: 'assets/image3.png'
    }
  ];
}
