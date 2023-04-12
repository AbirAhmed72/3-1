import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ItemService } from '../item.service';
import { Item } from '../item';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})

export class UpdateComponent implements OnInit{
  constructor(private itemService: ItemService, private router: Router) {
  }
  myItem: Item = new Item();
  ngOnInit(): void {
    this.myItem = this.itemService.getItemToBeUpdated();
  }

  update(): void{
    this.router.navigate(["items"]);
  }
}
