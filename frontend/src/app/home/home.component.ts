import { Component, OnInit } from "@angular/core";
import { Tipo, Ordem } from "../model";
import { ServicesService } from "../services.service";

@Component({
  selector: "app-home",
  templateUrl: "./home.component.html",
  styleUrls: ["./home.component.css"]
})
export class HomeComponent implements OnInit {
  tipos: Tipo[] = [];
  ordens: Ordem[] = [];

  constructor(private serv: ServicesService) {}

  ngOnInit() {
    this.getall();
  }

  getall() {
    this.serv.getallOrdem().subscribe(ordem => {
      this.ordens = ordem;
    });
    this.serv.getallTipos().subscribe(tipo => {
      this.tipos = tipo;
    });
  }
}
