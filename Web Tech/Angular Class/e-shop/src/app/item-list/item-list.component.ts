import { Component, OnInit } from '@angular/core';
import { Item } from '../item';
import { ItemService } from '../item.service';

@Component({
  selector: 'app-item-list',
  templateUrl: './item-list.component.html',
  styleUrls: ['./item-list.component.css']
})
export class ItemListComponent implements OnInit{
  constructor(private itemService: ItemService){}
  myItems: Item[] = [];
  ngOnInit(): void {
      console.log(this.itemService.getItems());
      this.myItems = this.itemService.getItems();
  }

  requestItem(quantity: Number): void{
    
    alert("item " + quantity + " requested");
  }

  buyItem(id: any): void{
    this.myItems[id-1].quantity = this.myItems[id-1].quantity-1;
    this.itemService.setItems(this.myItems);
    console.log(this.itemService.getItems());  
    alert("item now became: " + this.myItems[id-1].quantity + " pieces");
  }
}
