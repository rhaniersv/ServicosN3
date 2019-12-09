import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Tipo, Ordem } from "./model";

@Injectable({
  providedIn: "root"
})
export class ServicesService {
  api = "http://localhost:8080";

  constructor(private http: HttpClient) {}

  getallTipos() {
    return this.http.get<Tipo[]>(`${this.api}/tipo`);
  }

  getallOrdem() {
    return this.http.get<Ordem[]>(`${this.api}/ordem`);
  }
}
