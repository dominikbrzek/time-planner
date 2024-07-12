import {Component, OnInit} from '@angular/core';
import {Task} from "../model/task";
import {TaskService} from "../service/task.service";
import {NgForOf, NgIf} from "@angular/common";
import {FormsModule} from "@angular/forms";

@Component({
  selector: 'app-task-list',
  templateUrl: './task-list.component.html',
  standalone: true,
  imports: [
    NgForOf,
    NgIf,
    FormsModule
  ],
  styleUrl: './task-list.component.scss'
})
export class TaskListComponent implements OnInit {

  tasks: Task[] = [];
  priorities: string[] = [];
  taskToAdd: Task = new Task();

  constructor(private taskService: TaskService) {
  }

  ngOnInit(): void {
    this.getTasks();
    this.getPriorities();
  }

  private getTasks() {
    this.taskService.getTasks().subscribe(data =>
      this.tasks = data);
  }

  private getPriorities() {
    this.taskService.getPriorities().subscribe(data =>
      this.priorities = data);
  }

  deleteTask(id: string){
    this.taskService.deleteTask(id).subscribe({complete: console.info});
    this.tasks = this.tasks.filter(task => task.id !== id);
  }

  toggleEdit(task: Task) {
    task.isEditing = !task.isEditing;
  }

  cancelEdit(task: Task) {
    task.isEditing = false;
  }

  saveTask(task: Task) {
    task.isEditing = false;
    this.taskService.updateTask(task).subscribe({complete: console.info});
  }

  addTask() {
    this.taskService.addTask(this.taskToAdd).subscribe({complete: console.info});
    this.taskToAdd = new Task();
  }

}
