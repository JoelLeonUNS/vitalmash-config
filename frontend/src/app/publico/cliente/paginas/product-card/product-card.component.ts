import { Component } from '@angular/core';
import { CommonModule } from '@angular/common'; // Importación necesaria
import { NzCardModule } from 'ng-zorro-antd/card';
import { NzButtonModule } from 'ng-zorro-antd/button';
import { NzSelectModule } from 'ng-zorro-antd/select';
import { NzIconModule, NZ_ICONS } from 'ng-zorro-antd/icon';
import { HeartOutline } from '@ant-design/icons-angular/icons';
import { NzTagModule } from 'ng-zorro-antd/tag';
import { FormsModule } from '@angular/forms';
import { HeaderComponent } from "../../../../core/header/header.component";

@Component({
  selector: 'app-product-card',
  standalone: true,
  imports: [
    CommonModule, // Asegurarse de que CommonModule esté importado
    NzCardModule,
    NzButtonModule,
    NzSelectModule,
    NzIconModule,
    NzTagModule,
    FormsModule,
    HeaderComponent,
  ],
  providers: [
    {
      provide: NZ_ICONS,
      useValue: [HeartOutline], // Registrar íconos necesarios
    }
  ],
  templateUrl: './product-card.component.html',
  styleUrls: ['./product-card.component.css']
})
export class ProductCardComponent {
  selectedLiters = 2;
  selectedQuantity = 1;

  litersOptions = [
    { value: 1, label: '1 Litro' },
    { value: 2, label: '2 Litros' },
    { value: 3, label: '3 Litros' }
  ];

  quantityOptions = [
    { value: 1, label: '1 Unidad' },
    { value: 2, label: '2 Unidades' },
    { value: 3, label: '3 Unidades' }
  ];
}
