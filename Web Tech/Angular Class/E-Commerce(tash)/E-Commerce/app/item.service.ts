import { Injectable } from '@angular/core';
import { Item } from './item';

@Injectable({
  providedIn: 'root'
})
export class ItemService {

  constructor() { }

  items: Item[] = [
    {
      id:1,
      name: "Chocolate",
      price: 300,
      quantity: 10
    },
    {
      id:2,
      name: "Ice cream",
      price: 500,
      quantity: 0
    },
    {
      id:3,
      name: "Juice",
      price: 1000,
      quantity: 15
    }
  ];

  getItems(): Item[]{
    return this.items;
  }

  setItems(items: Item[]): void {
    this.items=items;
  }

  itemToBeUpdated: Item = new Item();

  setItemsToBeUpdated(index: number): void{
    let item = this.items[index];
    if(item!=null)
    {
        this.itemToBeUpdated=item;
    }
  }

  getItemToBeUpdated(): Item {
    return this.itemToBeUpdated;
  }
}
