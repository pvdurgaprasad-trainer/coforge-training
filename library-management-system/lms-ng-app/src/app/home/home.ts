import { Component, Inject, OnInit } from '@angular/core';
import { BookService } from '../service/book-service';
import { IBook } from '../model/book.model';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-home',
  imports: [CommonModule],
  templateUrl: './home.html',
  styleUrl: './home.css'
})
export class Home implements OnInit{
  books: IBook[] = [];
  isError:boolean = false;
  errorMsg:String = "";

  constructor(private service: BookService) { }
  ngOnInit(): void {
      this.service.getBooks().subscribe((resp:any)=>{
        console.log('response',resp)
        if(resp.status==="Success"){
            this.books = resp.data;
        }else{
          this.isError = true;
          this.errorMsg= resp.message;
        }
      })
  }
}
