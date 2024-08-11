import {Component, OnInit} from '@angular/core';
import {Task} from "../model/task";
import {TaskService} from "../service/task.service";
import {NgForOf, NgIf} from "@angular/common";
import {FormsModule} from "@angular/forms";
import {Subtask} from "../model/subtask";

@Component({
  selector: 'app-task-list',
  templateUrl: './task-list.component.html',
  standalone: true,
  imports: [NgForOf, NgIf, FormsModule],
  styleUrl: './task-list.component.scss'
})
export class TaskListComponent implements OnInit {

  tasks: Task[] = [];
  priorities: string[] = [];
  taskToAdd: Task = new Task();
  subtaskToAdd: Subtask = new Subtask();

  constructor(private taskService: TaskService) {
  }

  ngOnInit(): void {
    this.getTasks();
    this.getPriorities();
  }

  deleteTask(id: string) {
    this.taskService.deleteTask(id).subscribe({complete: console.info});
    this.tasks = this.tasks.filter(task => task.id !== id);
  }

  toggleEdit(task: Task) {
    task.isEditing = !task.isEditing;
  }

  toggleSubtaskEdit(subtask: Subtask, taskId: string) {
    if (subtask.isEditing) {
      this.subtaskToAdd = new Subtask();
    } else {
      this.subtaskToAdd.taskId = taskId;
    }
    subtask.isEditing = !subtask.isEditing;
  }

  saveTask(task: Task) {
    task.isEditing = false;
    this.taskService.updateTask(task).subscribe({complete: console.info});
  }

  addTask() {
    this.taskService.addTask(this.taskToAdd).subscribe({complete: console.info});
    this.taskToAdd.isEditing = false;
    this.tasks.push(this.taskToAdd);
    this.taskToAdd = new Task();
  }

  addSubtask(task: Task) {
    this.taskService.addSubtask(this.subtaskToAdd).subscribe({complete: console.info});
    this.subtaskToAdd.isEditing = false;
    task.subtasks.push(this.subtaskToAdd);
    this.subtaskToAdd = new Subtask();
  }

  deleteSubtask(subtask: Subtask, task: Task) {
    console.log("task: ", task)
    console.log("subtask: ", subtask)
    this.taskService.deleteSubtask(subtask.id).subscribe({complete: console.info});
    task.subtasks = task.subtasks.filter(subtask => subtask.id !== subtask.id);
  }

  saveSubtask(subtask: Subtask) {
    subtask.isEditing = false;
    this.taskService.updateSubtask(subtask).subscribe({complete: console.info});
  }

  private getTasks() {
    this.taskService.getTasks().subscribe(data => this.tasks = data);
  }

  private getPriorities() {
    this.taskService.getPriorities().subscribe(data => this.priorities = data);
  }
}
