import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {Stomp, IMessage} from '@stomp/stompjs';
import * as SockJS from 'sockjs-client';
@Injectable({
  providedIn: 'root'
})
export class WebsocketService {
  private stompClient;
  constructor() {
    const socket = new SockJS('http://localhost:8082/websocket');
    this.stompClient = Stomp.over(socket);
    this.stompClient.activate();
   }
   
   connectPatient():Observable<any>{
    return new Observable(observer => {
      this.stompClient.connect({}, () => {
        this.stompClient.subscribe('/topic/patients', (message:IMessage) => {
          observer.next(JSON.parse(message.body));
        });
      });
    });
   }
   connectDoctor():Observable<any>{
    return new Observable(observer => {
      this.stompClient.connect({}, () => {
        this.stompClient.subscribe('/topic/doctors', (message:IMessage) => {
          observer.next(JSON.parse(message.body));
        });
      });
    });
   }
   connectPriem():Observable<any>{
    return new Observable(observer => {
      this.stompClient.connect({}, () => {
        this.stompClient.subscribe('/topic/priems', (message:IMessage) => {
          observer.next(JSON.parse(message.body));
        });
      });
    });
   }
}
