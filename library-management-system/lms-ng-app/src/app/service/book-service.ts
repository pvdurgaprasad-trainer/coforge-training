import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { IBook } from '../model/book.model';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  constructor(private httpClient:HttpClient){ }

  baseUrl:String= "/api";

  getBooks(){
    return this.httpClient.get<any>(this.baseUrl+"/books");
  }

  postRequest(body:any){
    return this.httpClient.post<any>(this.baseUrl+"/student/request",body)
  }
}
