import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { BookService } from './service/book-service';
import { IBook } from './model/book.model';
import { CommonModule } from '@angular/common';


@Component({
  selector: 'app-root',
  imports: [RouterOutlet,CommonModule],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {

  constructor(private bookService: BookService) { }
  
  books:IBook[] = [];
  selectedBooks:Set<number>=new Set<number>([]);

  showBooks() {
    this.bookService.getBooks().subscribe(response=>{
     this.books = (response.data);
    });
  }

  addBook(cb:any){
    if(cb.target.checked){
      if(!this.selectedBooks.has(cb.target.value)){
        this.selectedBooks.add(cb.target.value);
      }      
    }else{
      this.selectedBooks.delete(cb.target.value);
    }
    console.log(this.selectedBooks);
  }

  sendRequest(){
    var books:any = [];
    this.selectedBooks.forEach(e=>books=[...books,e]);
    let request:any = {
      "studentId":123,
      "bookIds": books
    };
    this.bookService.postRequest(request).subscribe();
  }
}
