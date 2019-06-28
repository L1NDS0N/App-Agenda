import { Http } from '@angular/http';
import { Injectable } from '@angular/core';
import 'rxjs/add/operator/toPromise';

@Injectable()
export class AppService {

  constructor(private http: Http) { }

  consultar(): Promise<any> {
    return this.http.get('http://localhost:8080/contato')
      .toPromise()
      .then(response => response.json())
  }

  salvar(contato: any): Promise<any>{
    return this.http.post('http://localhost:8080/contato', contato)
    .toPromise()
    .then(response => response.json())
  }

  excluir(id: number): Promise<void> {
    return this.http.delete(`http://localhost:8080/contato/remover/${id}`)
    .toPromise()
    .then(() => null)
  }

  obter(contato: any): Promise<any> {
    return this.http.get(`http://localhost:8080/contato/editar/${contato.id}`, contato)
    .toPromise()
    .then(response => response.json())
  }

  atualizar(contato: any): Promise<any> {
    return this.http.put(`http://localhost:8080/contato/atualizar/${contato.id}`, contato)
      .toPromise()
      .then(response => response.json())
  }

}
