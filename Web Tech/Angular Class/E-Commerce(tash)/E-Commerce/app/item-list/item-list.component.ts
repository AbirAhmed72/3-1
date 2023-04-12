import { Component, OnInit } from '@angular/core';
import { ItemService } from '../item.service';
import { Item } from '../item';
import { Router} from '@angular/router';

@Component({
  selector: 'app-item-list',
  templateUrl: './item-list.component.html',
  styleUrls: ['./item-list.component.css']
})
export class ItemListComponent implements OnInit{

  constructor(private itemService: ItemService, private router: Router){}

  myItems: Item[] = [];
  ngOnInit(): void {
      this.myItems = this.itemService.getItems();
      console.log(this.myItems);
  }

  requestItem(item_name: string, index: number): void
  {
    alert("Request stock " + item_name);
    this.myItems[index].quantity+=5;
  }

  buyItem(index:  number): void {
    this.myItems[index].quantity--;
  }

  updateItem(index: number){
    this.itemService.setItemsToBeUpdated(index);
    this.router.navigate(["update"]);
  }
}
