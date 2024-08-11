import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {Task} from "../model/task";
import {Subtask} from "../model/subtask";

@Injectable({
  providedIn: 'root'
})
export class TaskService {

  httpOptions = {
    headers: new HttpHeaders({
      'Accept': 'application/json', 'Content-Type': 'application/json'
    })
  };
  private taskBaseURL = "http://localhost:8080/api/v1/task"
  private subtaskBaseURL = "http://localhost:8080/api/v1/subtask"

  constructor(private httpClient: HttpClient) {
  }

  getTasks(): Observable<Task[]> {
    return this.httpClient.get<Task[]>(`${this.taskBaseURL}`, this.httpOptions);
  }

  getPriorities(): Observable<string[]> {
    return this.httpClient.get<string[]>(`${this.taskBaseURL + "/priorities"}`, this.httpOptions);
  }

  deleteTask(id: string): Observable<any> {
    return this.httpClient.delete(`${this.taskBaseURL + "/" + id}`, this.httpOptions);
  }

  deleteSubtask(id: string): Observable<any> {
    return this.httpClient.delete(`${this.subtaskBaseURL + "/" + id}`, this.httpOptions);
  }

  addTask(task: Task): Observable<any> {
    return this.httpClient.post(`${this.taskBaseURL}`, task, this.httpOptions);
  }

  addSubtask(task: Subtask): Observable<any> {
    return this.httpClient.post(`${this.subtaskBaseURL}`, task, this.httpOptions);
  }

  updateTask(task: Task): Observable<any> {
    return this.httpClient.put(`${this.taskBaseURL}`, task, this.httpOptions);
  }

  updateSubtask(subtask: Subtask): Observable<any> {
    return this.httpClient.put(`${this.subtaskBaseURL}`, subtask, this.httpOptions);
  }
}
