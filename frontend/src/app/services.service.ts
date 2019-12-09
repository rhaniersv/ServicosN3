import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http'


@Injectable({
  providedIn: 'root'
})

export class ServicesService {

  constructor( http: HttpClient) { }

  ngOnInit(){

  }

  getAll(){
    return this.http.get()
  }
}
