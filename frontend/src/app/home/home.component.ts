import { Component, OnInit } from "@angular/core";
import { Tipo, Ordem } from "../model";
import { ServicesService } from "../services.service";

@Component({
  selector: "app-home",
  templateUrl: "./home.component.html",
  styleUrls: ["./home.component.css"]
})
export class HomeComponent implements OnInit {
  tipos: Tipo[];
  ordens: Ordem[];

  constructor(private serv: ServicesService) {}

  ngOnInit() {}

  getall() {
    console.log("Parabéns esse botão funciona!");

    this.serv.getallOrdem().subscribe(resp => {
      resp = this.ordens;
    });
    this.serv.getallTipos().subscribe(resp => {
      resp = this.tipos;
    });
  }
}
