import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";
import {Task} from "../model/task";
import {v4 as uuid} from "uuid";

@Injectable({
  providedIn: 'root'
})
export class TaskService {

  constructor(private httpClient: HttpClient) {}
  private baseURL = "http://localhost:8080/api/v1/task"

  httpOptions = {
    headers: new HttpHeaders({
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    })
  };

  getTasks(): Observable<Task[]> {
    return this.httpClient.get<Task[]>(`${this.baseURL}`, this.httpOptions);
  }

  getPriorities(): Observable<string[]> {
    return this.httpClient.get<string[]>(`${this.baseURL + "/priorities"}`, this.httpOptions);
  }

  deleteTask(id: string): Observable<any> {
    return this.httpClient.delete(`${this.baseURL + "/" + id}`, this.httpOptions);
  }

  addTask(task: Task): Observable<any> {
    return this.httpClient.post(`${this.baseURL}`, task, this.httpOptions);
  }

  updateTask(task: Task): Observable<any> {
    return this.httpClient.put(`${this.baseURL}`, task, this.httpOptions);
  }


  updateTaskPriority(id: string, priority: string): Observable<any> {
    let options = {
      headers: new HttpHeaders({
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        "Priority": priority
      })};

    console.log(id, priority)
    return this.httpClient.put(`${this.baseURL }`, options);
  }
}
