import { Injectable } from '@angular/core';
import { Item } from './item';

@Injectable({
  providedIn: 'root'
})
export class ItemService {

  constructor() { }

  items: Item[] = [
    {id: 1, name: "iphone", price: 2000, quantity: 3},
    {id: 2, name: "macbook", price: 10000, quantity: 2},
    {id: 3, name: "OPPO", price: 300, quantity: 8}
  ];

  getItems(): Item[]{
    return this.items;
  }
}
