import { AppService } from './app.service'
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  contatos = [];
  dadosrecebidos = [];
  // cepobtido = [];


  constructor(private appService: AppService) {}

  ngOnInit() {
    this.consultar()

  }

  consultar(){
    this.appService.consultar()
    .then(dados => {
      this.contatos = dados;
      console.log(dados);
    })
  }

  salvar(nome: string, fone: string, email: string) {
    this.appService.salvar({ nome, fone, email })
    .then(contato => {
      this.consultar();
    });
  }

  excluir(id: number) {
    this.appService.excluir(id)
    .then(() => this.consultar()
  );
}

obter(contato: any) {
  this.appService.obter(contato)
  .then(dados => {
    this.dadosrecebidos = dados;
  });
}

atualizar(id: number, nome: string, fone: string, email: string) {
  this.appService.atualizar({ id, nome, fone, email })
  .then(() => {
    this.consultar();
  });
}
}
