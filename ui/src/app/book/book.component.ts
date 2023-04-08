import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { error } from 'console';

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']
})
export class BookComponent implements OnInit {

  title = 'Books Management'
  books: any = [];

  isGreen = true
  

  constructor(private router : Router, private http: HttpClient) { }

  ngOnInit(): void {
    this.fetchAllBooks()
  }

  addBook(){
    console.log("addBook button clicked")
    //Take user to /add-book url
    this.router.navigateByUrl('/add-book')
  }

  fetchAllBooks(){
    this.http.get("http://localhost:8080/books/getAll")
    .subscribe(resp => {
      this.books=resp;
      console.log('Books retrieved successfully',this.books)
    }, error => {
      console.error('Error retrieving books:',error);
    });
  }

  deleteBook(bookID:Number){
    
    const url = 'http://localhost:8080/books/delete/'+bookID
    console.log(url)
    this.http.delete(url)
    .subscribe(resp => {
      console.log('Book deleted successfully');
      this.fetchAllBooks()
    }, error => {
      console.error('Error deleting books:',error);
    });
  }
}